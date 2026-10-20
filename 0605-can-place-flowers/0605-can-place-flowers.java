class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0 ;
        int len = flowerbed.length ;
        
        for( int i = 0 ; i < len ; i++ ){
            if( flowerbed[i] == 0 ){
                boolean leftEmpty = ( i == 0 || flowerbed[i - 1] == 0 ) ;
                boolean rightEmpty = ( i == len - 1 || flowerbed[i + 1] == 0 ) ;
                
                if( leftEmpty && rightEmpty ){
                    flowerbed[i] = 1 ;
                    cnt++ ;
                    if( cnt >= n ) return true ;
                }
            }
        }
        return cnt >= n ;
    }
}