class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[102] ;
        
      for ( int x : nums ) {
          cnt[x + 1]++ ;
      }
      for ( int i = 1 ; i <= 101 ; i++ ) {
          cnt[i] += cnt[i - 1] ;
      }
      
        int[] ans = new int[nums.length] ;
      for ( int i = 0 ; i < nums.length ; i++ ) {
          ans[i] = cnt[nums[i]] ;
      }
      
        return ans ;
    }
}