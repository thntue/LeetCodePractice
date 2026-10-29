import java.util.ArrayList ;
import java.util.List ;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        // 1. Danh sach ke
        List<Integer>[] adj = new ArrayList[n] ;
        for ( int i = 0 ; i < n ; i++ ) {
            adj[i] = new ArrayList<>() ;
        }
        for ( int[] e : edges ) {
            adj[e[0]].add( e[1] ) ;
            adj[e[1]].add( e[0] ) ;
        }

        int[] tin = new int[n] ;
        int[] tout = new int[n] ;
        int[] depth = new int[n] ;
        int[][] up = new int[n][17] ;
        int[] initialPref = new int[n] ;

        // 2. DFS bang Stack tranh tran bo nho
        int[] stack = new int[n] ;
        int[] edgeIdx = new int[n] ;
        int top = 0 ;
        int timer = 0 ;

        stack[0] = 0 ;
        edgeIdx[0] = 0 ;
        tin[0] = ++timer ;
        depth[0] = 0 ;
        up[0][0] = 0 ;
        initialPref[0] = 1 << (s.charAt(0) - 'a') ;

        while ( top >= 0 ) {
            int u = stack[top] ;
            if ( edgeIdx[u] < adj[u].size() ) {
                int v = adj[u].get( edgeIdx[u]++ ) ;
                if ( v != up[u][0] ) {
                    up[v][0] = u ;
                    depth[v] = depth[u] + 1 ;
                    initialPref[v] = initialPref[u] ^ (1 << (s.charAt(v) - 'a')) ;
                    tin[v] = ++timer ;
                    edgeIdx[v] = 0 ;
                    top++ ;
                    stack[top] = v ;
                }
            } else {
                tout[u] = timer ;
                top-- ;
            }
        }

        // 3. Bang Binary Lifting tim LCA
        for ( int j = 1 ; j < 17 ; j++ ) {
            for ( int i = 0 ; i < n ; i++ ) {
                up[i][j] = up[up[i][j - 1]][j - 1] ;
            }
        }

        FenwickTree bit = new FenwickTree( n ) ;
        char[] currS = s.toCharArray() ;

        List<Boolean> ans = new ArrayList<>() ;

        // 4. Xu ly tung query
        for ( String q : queries ) {
            String[] parts = q.split(" ") ;
            if ( parts[0].equals("update") ) {
                int u = Integer.parseInt( parts[1] ) ;
                char c = parts[2].charAt(0) ;
                
                char oldC = currS[u] ;
                if ( oldC != c ) {
                    int delta = (1 << (oldC - 'a')) ^ (1 << (c - 'a')) ;
                    currS[u] = c ;
                    bit.update( tin[u], delta ) ;
                    bit.update( tout[u] + 1, delta ) ;
                }
            } else {
                int u = Integer.parseInt( parts[1] ) ;
                int v = Integer.parseInt( parts[2] ) ;
                
                int lca = getLCA( u, v, up, depth ) ;
                int prefU = initialPref[u] ^ bit.query( tin[u] ) ;
                int prefV = initialPref[v] ^ bit.query( tin[v] ) ;
                int valLCA = 1 << (currS[lca] - 'a') ;
                
                int pathMask = prefU ^ prefV ^ valLCA ;
                ans.add( Integer.bitCount( pathMask ) <= 1 ) ;
            }
        }

        return ans ;
    }

    private int getLCA(int u, int v, int[][] up, int[] depth) {
        if ( depth[u] < depth[v] ) {
            int t = u ; u = v ; v = t ;
        }
        for ( int j = 16 ; j >= 0 ; j-- ) {
            if ( depth[u] - (1 << j) >= depth[v] ) {
                u = up[u][j] ;
            }
        }
        if ( u == v ) return u ;
        for ( int j = 16 ; j >= 0 ; j-- ) {
            if ( up[u][j] != up[v][j] ) {
                u = up[u][j] ;
                v = up[v][j] ;
            }
        }
        return up[u][0] ;
    }

    static class FenwickTree {
        int[] tree ;
        int size ;

        FenwickTree(int n) {
            this.size = n + 2 ;
            this.tree = new int[this.size + 1] ;
        }

        void update(int i, int delta) {
            for ( ; i <= size ; i += i & -i ) {
                tree[i] ^= delta ;
            }
        }

        int query(int i) {
            int sum = 0 ;
            for ( ; i > 0 ; i -= i & -i ) {
                sum ^= tree[i] ;
            }
            return sum ;
        }
    }
}