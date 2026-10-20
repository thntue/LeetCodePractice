class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray() ;
        int l = 0 ;
        int r = arr.length - 1 ;
        
        while( l < r ){
            while( l < r && !isVowel(arr[l]) ){
                l++ ;
            }
            while( l < r && !isVowel(arr[r]) ){
                r-- ;
            }
            
            if( l < r ){
                char tmp = arr[l] ;
                arr[l] = arr[r] ;
                arr[r] = tmp ;
                l++ ;
                r-- ;
            }
        }
        return new String( arr ) ;
    }
    
    private boolean isVowel( char c ){
        c = Character.toLowerCase( c ) ;
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ;
    }
}