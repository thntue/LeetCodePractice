class Solution {
    int res = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        
       dfs(root, targetSum); 
       pathSum(root.left, targetSum);
       pathSum(root.right, targetSum);
        
       return res;
    }
    
    private void dfs(TreeNode node, long tmp) {
        if (node == null) return; 
        
        if(node.val == tmp) {
            res++;
        }
        
        dfs(node.left, tmp - node.val);
       dfs(node.right, tmp - node.val);
    }
}