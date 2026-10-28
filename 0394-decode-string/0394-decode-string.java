import java.util.Stack ;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>() ;
        Stack<StringBuilder> strStack = new Stack<>() ;
        StringBuilder cur = new StringBuilder() ;
        int k = 0 ;
        
        for ( char c : s.toCharArray() ) {
            if ( Character.isDigit( c ) ) {
                k = k * 10 + (c - '0') ;
            } else if ( c == '[' ) {
                countStack.push( k ) ;
                strStack.push( cur ) ;
                cur = new StringBuilder() ;
                k = 0 ;
            } else if ( c == ']' ) {
                StringBuilder prev = strStack.pop() ;
                int repeat = countStack.pop() ;
                while ( repeat-- > 0 ) {
                    prev.append( cur ) ;
                }
                cur = prev ;
            } else {
                cur.append( c ) ;
            }
        }
        
        return cur.toString() ;
    }
}