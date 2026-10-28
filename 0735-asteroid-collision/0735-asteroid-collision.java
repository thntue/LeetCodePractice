import java.util.Stack ;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>() ;
        
        for ( int ast : asteroids ) {
            boolean exploded = false ;
            
            while ( !st.isEmpty() && ast < 0 && st.peek() > 0 ) {
                if ( st.peek() < -ast ) {
                    st.pop() ; // thien thach trong stack nho hon nen no
                } else if ( st.peek() == -ast ) {
                    st.pop() ; // ca 2 cung no
                    exploded = true ;
                    break ;
                } else {
                    exploded = true ; // thien thach hien tai bi no
                    break ;
                }
            }
            
            if ( !exploded ) {
                st.push( ast ) ;
            }
        }
        
        int[] ans = new int[st.size()] ;
        for ( int i = ans.length - 1 ; i >= 0 ; i-- ) {
            ans[i] = st.pop() ;
        }
        return ans ;
    }
}