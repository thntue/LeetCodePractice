class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        java.util.List<Integer> arr1 = new java.util.ArrayList<>();
       java.util.List<Integer> arr2 = new java.util.ArrayList<>();
        
        dfs(root1, arr1);
       dfs(root2, arr2); 
        
       if(arr1.size() != arr2.size()) return false;
       
       for(int i = 0; i < arr1.size(); i++) {
           if(!arr1.get(i).equals(arr2.get(i))) {
               return false;
           }
       }
       return true;
    }
    
    private void dfs(TreeNode node, java.util.List<Integer> kq) {
        if (node == null) return;
        if(node.left == null && node.right == null) 
        {
            kq.add(node.val);
        }
        dfs(node.left, kq);
       dfs(node.right, kq);
    }
}