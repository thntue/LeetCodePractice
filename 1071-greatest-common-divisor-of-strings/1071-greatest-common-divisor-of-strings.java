class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // gop thu 2 chieu, neu khac nhau thi khong bao gio co uoc chung
        if( !(str1 + str2).equals(str2 + str1) ){
            return "" ;
        }
        
        int gcdLen = getGcd( str1.length(), str2.length() ) ;
        return str1.substring( 0, gcdLen ) ;
    }
    
    private int getGcd( int a, int b ){
        while( b != 0 ){
            int tmp = a % b ;
            a = b ;
            b = tmp ;
        }
        return a ;
    }
}