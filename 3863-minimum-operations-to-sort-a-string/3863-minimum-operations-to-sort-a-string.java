class Solution {
    public int minOperations(String s) {
        int n = s.length() ;
        
        boolean sorted = true ;
        for ( int i = 0 ; i < n - 1 ; i++ ) {
            if ( s.charAt(i) > s.charAt(i + 1) ) {
                sorted = false ;
                break ;
            }
        }
        if ( sorted ) return 0 ;
        
        if ( n == 2 )  return -1 ;
        
        char minC = 'z' + 1 ;
        char maxC = 'a' - 1 ;
        for ( int i = 0 ; i < n ; i++ ) {
            char c = s.charAt(i) ;
            if ( c < minC )  minC = c ;
            if ( c > maxC )  maxC = c ;
        }
        
        if ( s.charAt(0) == minC || s.charAt(n - 1) == maxC ) {
            return 1 ;
        }
        
        int cntMin = 0 ;
        int cntMax = 0 ;
        for ( int i = 0 ; i < n ; i++ ) {
            char c = s.charAt(i) ;
            if ( c == minC ) cntMin++ ;
            if ( c == maxC ) cntMax++ ;
        }
        
        if ( s.charAt(0) == maxC && s.charAt(n - 1) == minC && cntMax == 1 && cntMin == 1 ) {
            return 3 ;
        }
        
        return 2 ;
    }
}