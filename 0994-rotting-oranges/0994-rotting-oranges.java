class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
       int n = grid[0].length;
       java.util.Queue<int[]> q = new java.util.LinkedList<>();
       int fresh = 0; 
        
       for(int i = 0; i < m; i++) 
       {
           for (int j = 0; j < n; j++) {
               if (grid[i][j] == 2) {
                   q.add(new int[]{i, j});
               } else if(grid[i][j] == 1) {
                    fresh++; 
               }
           }
       }
       
       if(fresh == 0) return 0;
       
       int dem = 0;
       int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
       while (q.size() > 0 && fresh > 0) {
            int sz = q.size();
           for(int i = 0; i < sz; i++) 
           {
               int[] tmp = q.poll();
               for(int[] d : dirs) {
                   int r = tmp[0] + d[0];
                    int c = tmp[1] + d[1];
                   if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                       grid[r][c] = 2;
                       fresh--;
                        q.add(new int[]{r, c});
                   }
               }
           }
           dem++;
       }
       
       if(fresh == 0) return dem;
       return -1; 
    }
}