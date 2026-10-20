import java.util.ArrayList ;
import java.util.List ;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length ;
        int ans = 0 ;
        
        List<Integer> divs = new ArrayList<>() ;
        for( int i = 1 ; i * i <= n ; i++ ){
            if( n % i == 0 ){
                divs.add( i ) ;
                if( i * i != n ) {
                    divs.add( n / i ) ;
                }
            }
        }
        
      for( int k : divs ){
          if( check( nums, n, k ) ) {
              ans += k ;
          }
      }
      
        return ans ;
    }
    
    private boolean check( int[] nums, int n, int k ){
        int prevMax = -1 ;
        
        for( int i = 0 ; i < n ; i += k ){
            int minV = nums[i] ;
            int maxV = nums[i] ;
            int drops = 0 ;
            
            for( int j = 0 ; j < k ; j++ ){
                int cur = nums[i + j] ;
                int nxt = nums[i + (j + 1) % k] ;
                
                if( cur > nxt ){
                    drops++ ;
                }
                if( cur < minV )  minV = cur ;
                if( cur > maxV )  maxV = cur ;
            }
            
            if( drops > 1 )  return false ;
            
            if( prevMax != -1 && prevMax > minV ){
                return false ;
            }
            prevMax = maxV ;
        }
        
        return true ;
    }
}