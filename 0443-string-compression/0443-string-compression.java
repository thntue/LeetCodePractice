class Solution {
    public int compress(char[] chars) {
        int ans = 0 ;
        int i = 0 ;
        
        while( i < chars.length ){
            char curChar = chars[i] ;
            int cnt = 0 ;
            
            // dem chuoi ky tu trung lap
            while( i < chars.length && chars[i] == curChar ){
                cnt++ ;
                i++ ;
            }
            
            chars[ans++] = curChar ;
            
            if( cnt > 1 ){
                String s = Integer.toString( cnt ) ;
                for( char c : s.toCharArray() ){
                    chars[ans++] = c ;
                }
            }
        }
        
        return ans ;
    }
}