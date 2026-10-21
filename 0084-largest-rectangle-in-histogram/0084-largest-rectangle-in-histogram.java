import java.util.Stack ;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length ;
        Stack<Integer> st = new Stack<>() ;
        int maxArea = 0 ;
        
      for ( int i = 0 ; i <= n ; i++ ) {

          int curHeight = ( i == n ) ? 0 : heights[i] ;
          
          while ( !st.isEmpty() && curHeight < heights[st.peek()] ) {
              int h = heights[st.pop()] ;
              int w = st.isEmpty() ? i : i - st.peek() - 1 ;
              if ( h * w > maxArea ) {
                  maxArea = h * w ;
              }
          }
          st.push( i ) ;
      }
      
        return maxArea ;
    }
}