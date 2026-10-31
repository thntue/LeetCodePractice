
class Solution {
    int dem = 0;
    
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
       dem = 0; 
       dfs(root, root.val);
       return dem;
    }
    
    private void dfs(TreeNode node, int tmp) {
        if(node == null) return;
        
        if(node.val >= tmp) 
        {
            dem++;
            tmp = node.val; // cap nhat lai
        }
        
        dfs(node.left, tmp);
       dfs(node.right, tmp);
    }
}