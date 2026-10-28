import java.util.Arrays ;
import java.util.HashMap ;
import java.util.Map ;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length ;
        Map<String, Integer> map = new HashMap<>() ;
        
        for ( int[] row : grid ) {
            String r = Arrays.toString( row ) ;
            map.put( r, map.getOrDefault( r, 0 ) + 1 ) ;
        }
        
        int ans = 0 ;
        for ( int c = 0 ; c < n ; c++ ) {
            int[] col = new int[n] ;
            for ( int r = 0 ; r < n ; r++ ) {
                col[r] = grid[r][c] ;
            }
            String colStr = Arrays.toString( col ) ;
            ans += map.getOrDefault( colStr, 0 ) ;
        }
        
        return ans ;
    }
}