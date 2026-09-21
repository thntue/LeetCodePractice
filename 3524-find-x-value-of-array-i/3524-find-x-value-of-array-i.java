import java.util.Arrays;

public class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        long[] nextDp = new long[k];
        
        for (int num : nums) {
            Arrays.fill(nextDp, 0);
            int remainder = num % k;
    
            nextDp[remainder]++;
            
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int nextRemainder = (r * remainder) % k;
                    nextDp[nextRemainder] += dp[r];
                }
            }
            
            
            for (int r = 0; r < k; r++) {
                result[r] += nextDp[r];
                dp[r] = nextDp[r]; 
            }
        }
        
        return result;
    }
}