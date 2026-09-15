public class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        
       
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPal[i][i] = true;
        }
        
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2 || isPal[i + 1][j - 1]) {
                        isPal[i][j] = true;
                    }
                }
            }
        }
        
        
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
           
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            
            
            for (int start = i - k + 1; start >= 0; start--) {
                if (isPal[start][i]) {
                    int prevCount = (start == 0) ? 0 : dp[start - 1];
                    dp[i] = Math.max(dp[i], prevCount + 1);
                    break; 
                }
            }
        }
        
        return dp[n - 1];
    }
}