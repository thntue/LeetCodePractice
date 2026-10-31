import java.util.Stack;

class StockSpanner {
   Stack<int[]> st; 
   
   public StockSpanner() {
        st = new Stack<>(); 
   }
   
    public int next(int price) {
       int dem = 1;  
       int tmp = price; // luu tam bien nay
       
       while(st.size() > 0 && st.peek()[0] <= tmp) 
       {
            int[] top_val = st.pop();
           dem = dem + top_val[1];
       }
       
       // mang 2 phan tu de luu gia va dem
       int[] kq = new int[2];
        kq[0] = tmp;
       kq[1] = dem;
       
       st.push(kq); 
       
       return dem; 
    }
}