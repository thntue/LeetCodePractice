class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
       int n = maze[0].length;
       java.util.Queue<int[]> q = new java.util.LinkedList<>(); 
       
       q.add(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
       
       int dem = 0;
       int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; //test
       
       while(q.size() > 0) 
       {
           int sz = q.size();
           for(int i=0; i < sz; i++) {
                int[] tmp = q.poll();
               int r = tmp[0];
               int c = tmp[1];
               
               if ((r != entrance[0] || c != entrance[1]) && (r == 0 || r == m-1 || c == 0 || c == n-1)) {
                   return dem;
               }
               
               for(int[] d : dirs) 
               {
                   int nr = r + d[0];
                    int nc = c + d[1];
                   if(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.') {
                       maze[nr][nc] = '+'; 
                       q.add(new int[]{nr, nc});
                   }
               }
           }
           dem++; 
       }
       return -1;
    }
}