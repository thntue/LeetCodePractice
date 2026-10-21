class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0 ;
        int cur = 0 ;
        
      for( int x : nums ){
          if( x == 1 ){
              cur++ ;
              if( cur > ans ){
                  ans = cur ;
              }
          } else {
              cur = 0 ;
          }
      }
      
        return ans ;
    }
}