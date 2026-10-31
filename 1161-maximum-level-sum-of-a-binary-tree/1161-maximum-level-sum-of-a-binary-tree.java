class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
       int max_val = Integer.MIN_VALUE; 
       int kq = 1;
        int level = 1; 
        
       java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
       q.add(root);
       
       while (q.size() > 0) {
            int sz = q.size();
           int dem = 0;
           
            for(int i = 0; i < sz; i++) 
            {
               TreeNode tmp = q.poll();
               dem = dem + tmp.val; // cong don
               
               if (tmp.left != null) q.add(tmp.left);
               if (tmp.right != null) q.add(tmp.right);
            }
            
           if(dem > max_val) { // test thu 
               max_val = dem;
                kq = level;
           }
           level++;
       }
       return kq; 
    }
}