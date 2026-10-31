
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        
      java.util.Arrays.sort(intervals, (x, y) -> Integer.compare(x[1], y[1])); 
      
        int dem = 0;
       int cuoi = intervals[0][1]; // test thu xem pass k
        
       for(int i = 1; i < intervals.length; i++) {
           int[] arr1 = intervals[i];
           
           if(arr1[0] < cuoi) 
           {
               dem++; 
           } 
           else {
               cuoi = arr1[1]; 
           }
       }
       
       return dem;
    }
}