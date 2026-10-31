class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
       int r = 1000000000;
       
       while (l <= r) {
           int mid = l + (r - l) / 2;
           
           long dem = 0;
           for(int i = 0; i < piles.length; i++) 
           {
                int tmp = piles[i];
               dem = dem + (tmp / mid);
               if (tmp % mid != 0) {
                   dem++;
               }
           }
           
           if (dem <= h) 
           {
                r = mid - 1;
           } 
           else {
               l = mid + 1;
           }
       }
        return l;
    }
}