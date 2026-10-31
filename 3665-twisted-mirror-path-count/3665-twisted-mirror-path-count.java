class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;
        
        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || dp[i][j] == 0) continue;

                for (int startDir = 0; startDir <= 1; startDir++) {
                    int r = i, c = j;
                    int dir = startDir; 
                    
                    while (true) {
                        if (dir == 0) c++; 
                        else r++;
                        
                        if (r < 0 || r >= m || c < 0 || c >= n) {
                            break; 
                        }
                        
                        if (grid[r][c] == 0) {
                            dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                            break;
                        } else {
                            dir = 1 - dir; 
                        }
                    }
                }
            }
        }
        
        return (int) dp[m - 1][n - 1];
    }
}