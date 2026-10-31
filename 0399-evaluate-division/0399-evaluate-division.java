class Solution {
    public double[] calcEquation(java.util.List<java.util.List<String>> equations, double[] values, java.util.List<java.util.List<String>> queries) {
        java.util.Map<String, java.util.List<Node>> adj = new java.util.HashMap<>();
        
       for(int i = 0; i < equations.size(); i++) {
           String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
           double val = values[i]; 
           
           adj.putIfAbsent(u, new java.util.ArrayList<>());
           adj.putIfAbsent(v, new java.util.ArrayList<>());
           adj.get(u).add(new Node(v, val));
           adj.get(v).add(new Node(u, 1.0 / val));
       }
       
       double[] kq = new double[queries.size()];
       for (int i = 0; i < queries.size(); i++) 
       {
           String u = queries.get(i).get(0);
           String v = queries.get(i).get(1);
           
           if(!adj.containsKey(u) || !adj.containsKey(v)) {
                kq[i] = -1.0;
           } else {
               java.util.HashSet<String> visited = new java.util.HashSet<>();
               double[] res = {-1.0}; 
               dfs(u, v, 1.0, adj, visited, res); // test thu xem pass k
               kq[i] = res[0];
           }
       }
       return kq;
    }
    
    class Node {
        String name;
       double val;
       Node(String n, double v) { name = n; val = v; }
    }
    
    private void dfs(String cur, String target, double tmp, java.util.Map<String, java.util.List<Node>> adj, java.util.HashSet<String> visited, double[] res) {
        visited.add(cur);
       if(cur.equals(target)) 
       {
           res[0] = tmp;
           return;
       }
       
       for(Node next : adj.get(cur)) {
           if(!visited.contains(next.name)) {
               dfs(next.name, target, tmp * next.val, adj, visited, res);
           }
       }
    }
}