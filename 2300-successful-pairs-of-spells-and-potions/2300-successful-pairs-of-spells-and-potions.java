
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
       int m = potions.length;
       int[] kq = new int[n];
        
       java.util.Arrays.sort(potions); // phai sort ms nhi phan dc
       
       for (int i = 0; i < n; i++) 
       {
           int l = 0;
            int r = m - 1;
           int tmp = m; 
           
           while(l <= r) {
               int mid = l + (r - l)/2;
                long val = (long) spells[i] * potions[mid]; 
                
               if (val >= success) {
                   tmp = mid;
                    r = mid - 1;
               } else {
                   l = mid + 1;
               }
           }
           kq[i] = m - tmp;
       }
       
       return kq;
    }
}