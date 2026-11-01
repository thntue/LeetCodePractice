class Solution {
    public int minMoves(int[] nums) {
       int min_val = nums[0]; 
        
       for (int i = 1; i < nums.length; i++) 
       {
           if(nums[i] < min_val) {
                min_val = nums[i];
           }
       }
       
       int dem = 0;
        for(int i = 0; i < nums.length; i++) {
            int tmp = nums[i] - min_val; 
           dem += tmp; 
        }
        
       return dem;
    }
}