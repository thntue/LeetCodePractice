
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        
      // sap xep tang dan theo diem cuoi 
        java.util.Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
       int kq = 1; 
       int cuoi = points[0][1];
        
       for (int i = 1; i < points.length; i++) 
       {
           int[] tmp = points[i]; // luu tam bien nay cho de nhin
           if(tmp[0] > cuoi) {
               kq++;
               cuoi = tmp[1];
            }
       }
        
       return kq; 
    }
}