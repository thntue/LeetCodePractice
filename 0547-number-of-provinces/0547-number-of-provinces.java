class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
       int dem = 0;
       
       for(int i = 0; i < n; i++) 
       {
           if(visited[i] == false) {
               dem++;
                dfs(isConnected, visited, i);
           }
       }
       return dem; 
    }
    
    private void dfs(int[][] arr1, boolean[] visited, int idx) {
        visited[idx] = true; 
       for (int i = 0; i < arr1.length; i++) {
            int tmp = arr1[idx][i]; 
           if(tmp == 1 && visited[i] == false) 
           {
               dfs(arr1, visited, i); 
           }
       }
    }
}