import java.util.LinkedList ;
import java.util.Queue ;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>() ;
        Queue<Integer> dir = new LinkedList<>() ;
        int n = senate.length() ;
        
        for ( int i = 0 ; i < n ; i++ ) {
            if ( senate.charAt( i ) == 'R' ) {
                rad.offer( i ) ;
            } else {
                dir.offer( i ) ;
            }
        }
        
        while ( !rad.isEmpty() && !dir.isEmpty() ) {
            int rIdx = rad.poll() ;
            int dIdx = dir.poll() ;
            
            if ( rIdx < dIdx ) {
                rad.offer( rIdx + n ) ;
            } else {
                dir.offer( dIdx + n ) ;
            }
        }
        
        return rad.isEmpty() ? "Dire" : "Radiant" ;
    }
}