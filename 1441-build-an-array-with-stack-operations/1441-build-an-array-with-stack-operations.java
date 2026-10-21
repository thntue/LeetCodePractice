import java.util.ArrayList ;
import java.util.List ;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>() ;
        int idx = 0 ;
        
      for ( int i = 1 ; i <= n ; i++ ) {
          if ( idx >= target.length ) {
              break ;
          }
          
          ans.add( "Push" ) ;
          
          if ( i == target[idx] ) {
              idx++ ;
          } else {
              ans.add( "Pop" ) ;
          }
      }
      
        return ans ;
    }
}