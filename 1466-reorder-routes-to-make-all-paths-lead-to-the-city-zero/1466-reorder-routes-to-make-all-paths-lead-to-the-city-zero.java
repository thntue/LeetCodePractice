class Solution {
    int dem = 0; 
    
    public int minReorder(int n, int[][] connections) {
        java.util.List<java.util.List<int[]>> adj = new java.util.ArrayList<>();
       for(int i = 0; i < n; i++) {
           adj.add(new java.util.ArrayList<>());
       }
       
       for(int i = 0; i < connections.length; i++) 
       {
           int[] arr1 = connections[i];
           adj.get(arr1[0]).add(new int[]{arr1[1], 1}); 
           adj.get(arr1[1]).add(new int[]{arr1[0], 0}); // 0 la canh ao
       }
       
       boolean[] visited = new boolean[n];
        dfs(adj, visited, 0);
       return dem;
    }
    
    private void dfs(java.util.List<java.util.List<int[]>> adj, boolean[] visited, int idx) {
        visited[idx] = true;
       
       for (int i = 0; i < adj.get(idx).size(); i++) 
       {
           int[] tmp = adj.get(idx).get(i); 
            if(!visited[tmp[0]]) {
                dem += tmp[1]; 
               dfs(adj, visited, tmp[0]);
            }
       }
    }
}