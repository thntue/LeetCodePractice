
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        
       int l = 0;
       int r = n - 1;
        
       while(l < r) 
       {
            int mid = l + (r - l) / 2;
            int arr1 = nums[mid];
           int arr2 = nums[mid+1];
           
            if (arr1 > arr2) {
                r = mid;
            } else {
                l = mid + 1;
            }
       }
       
       return l; 
    }
}