
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode tmp = root; 
        
       while (tmp != null) 
       {
           if (tmp.val == val) {
               return tmp;
           } else if(tmp.val > val) {
               tmp = tmp.left; 
           } else {
                tmp = tmp.right;
           }
       }
       return null;
    }
}