class Solution {
    public boolean canVisitAllRooms(java.util.List<java.util.List<Integer>> rooms) {
        int n = rooms.size();
       boolean[] visited = new boolean[n]; 
       
       dfs(rooms, visited, 0); // test thu 
       
       int dem = 0;
       for (int i = 0; i < n; i++) 
       {
            if (visited[i] == true) {
                dem++;
            }
       }
        
       if (dem == n) return true;
       return false;
    }
    
    private void dfs(java.util.List<java.util.List<Integer>> arr1, boolean[] visited, int idx) {
        visited[idx] = true;
        
       for(int tmp : arr1.get(idx)) {
           if(visited[tmp] == false) 
           {
                dfs(arr1, visited, tmp);
           }
       }
    }
}