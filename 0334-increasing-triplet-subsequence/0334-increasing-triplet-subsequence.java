class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE ;
        int second = Integer.MAX_VALUE ;
        
        for( int x : nums ){
            if( x <= first ){
                first = x ;
            } else if( x <= second ){
                second = x ;
            } else {
                // tim thay phan tu lon hon ca 2 so nho nhat truoc do
                return true ;
            }
        }
        return false ;
    }
}