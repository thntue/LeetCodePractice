class Solution {
    public int largestAltitude(int[] gain) {
        int maxAlt = 0 ;
        int cur = 0 ;
        
        for ( int g : gain ) {
            cur += g ;
            if ( cur > maxAlt ) {
                maxAlt = cur ;
            }
        }
        
        return maxAlt ;
    }
}