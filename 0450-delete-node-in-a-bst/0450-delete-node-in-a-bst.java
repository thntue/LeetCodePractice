// Bai 450: Delete Node in a BST
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
       if(key < root.val) {
            root.left = deleteNode(root.left, key);
       } 
       else if (key > root.val) {
           root.right = deleteNode(root.right, key);
       } 
       else 
       {
           if(root.left == null) return root.right;
           if(root.right == null) return root.left;
           
           TreeNode tmp = root.right; // luu tam bien nay
           while(tmp.left != null) {
                tmp = tmp.left;
           }
           
           root.val = tmp.val;
           root.right = deleteNode(root.right, root.val);
       }
        return root; 
    }
}