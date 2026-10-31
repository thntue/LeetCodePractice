
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
       int l = maxDepth(root.left); 
       int r = maxDepth(root.right);
        
       if (l > r) {
            return l + 1;
       } else {
           return r + 1;
       }
    }
}