class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1 ;
        
        for ( int i = 0 ; i < nums.length ; i++ ) {
            // chi xet nhung phan tu nam sai vi tri can phai swap
            if ( nums[i] != i ) {
                if ( ans == -1 ) {
                    ans = nums[i] ;
                } else {
                    ans &= nums[i] ;
                }
            }
        }
        
        // neu mang da sap xep san thi tra ve 0 theo de bai
        return ans == -1 ? 0 : ans ;
    }
}