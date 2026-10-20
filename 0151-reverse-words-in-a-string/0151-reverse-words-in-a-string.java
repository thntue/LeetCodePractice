class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder() ;
        int i = s.length() - 1 ;
        
        while( i >= 0 ){
            // bo qua khoang trang thua
            while( i >= 0 && s.charAt(i) == ' ' ){
                i-- ;
            }
            if( i < 0 ) break ;
            
            int j = i ;
            while( i >= 0 && s.charAt(i) != ' ' ){
                i-- ;
            }
            
            if( res.length() > 0 ){
                res.append( " " ) ;
            }
            res.append( s.substring( i + 1, j + 1 ) ) ;
        }
        
        return res.toString() ;
    }
}