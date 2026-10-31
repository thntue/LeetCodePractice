class Solution {
    public java.util.List<Integer> rightSideView(TreeNode root) {
        java.util.List<Integer> kq = new java.util.ArrayList<>();
        if(root == null) return kq;
        
      java.util.Queue<TreeNode> q = new java.util.LinkedList<>(); 
       q.add(root);
        
       while(q.size() > 0) 
       {
            int sz = q.size();
           for(int i=0; i<sz; i++) {
               TreeNode tmp = q.poll();
                if (i == sz - 1) {
                    kq.add(tmp.val);
                }
               if(tmp.left != null) q.add(tmp.left);
               if(tmp.right != null) q.add(tmp.right);
           }
       }
       return kq;
    }
}