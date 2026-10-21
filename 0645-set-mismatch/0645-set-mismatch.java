class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length ;
        int[] cnt = new int[n + 1] ;
        int dup = -1, missing = -1 ;
        
      for( int x : nums ){
          cnt[x]++ ;
      }
      
      for( int i = 1 ; i <= n ; i++ ){
          if( cnt[i] == 2 ){
              dup = i ;
          } else if( cnt[i] == 0 ){
              missing = i ;
          }
      }
      
        return new int[]{ dup, missing } ;
    }
}