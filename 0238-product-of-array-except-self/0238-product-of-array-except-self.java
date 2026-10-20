class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length ;
        int[] ans = new int[n] ;
        
        // luot 1: tinh tich cac so ben trai
        ans[0] = 1 ;
        for( int i = 1 ; i < n ; i++ ){
            ans[i] = ans[i - 1] * nums[i - 1] ;
        }
        
        // luot 2: nhan tiep tich cac so ben phai
        int right = 1 ;
        for( int i = n - 1 ; i >= 0 ; i-- ){
            ans[i] = ans[i] * right ;
            right *= nums[i] ;
        }
        
        return ans ;
    }
}