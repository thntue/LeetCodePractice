class Solution {
    int max = 0; 
    
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
       dfs(root, true, 0);
       dfs(root, false, 0); 
        
       return max;
    }
    
    private void dfs(TreeNode node, boolean flag1, int dem) {
        if (node == null) return;
        
        if(dem > max) {
            max = dem;
        }
        
        if(flag1 == true) // di qua phai
        {
            dfs(node.right, false, dem + 1);
            dfs(node.left, true, 1);
        } 
        else {
            dfs(node.left, true, dem + 1);
           dfs(node.right, false, 1);
        }
    }
}