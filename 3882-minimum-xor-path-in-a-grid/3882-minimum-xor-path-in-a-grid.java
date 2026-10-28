class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        
        // dp[i][j][x] = true neu ton tai duong di den (i, j) co tong XOR bang x
        boolean[][][] dp = new boolean[m][n][1024] ;
        
        // Tach rieng gia tri xuat phat tranh bi dinh/nuot ngoac []
        int startVal = grid[0][0] ;
        dp[0][0][startVal] = true ;
        
        for ( int i = 0 ; i < m ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                if ( i == 0 && j == 0 ) {
                    continue ;
                }
                
                int val = grid[i][j] ;
                
                for ( int x = 0 ; x < 1024 ; x++ ) {
                    // Di tu tren xuong
                    if ( i > 0 && dp[i - 1][j][x] ) {
                        dp[i][j][x ^ val] = true ;
                    }
                    // Di tu trai sang
                    if ( j > 0 && dp[i][j - 1][x] ) {
                        dp[i][j][x ^ val] = true ;
                    }
                }
            }
        }
        
        // Tim gia tri XOR nho nhat tai dich (m - 1, n - 1)
        for ( int x = 0 ; x < 1024 ; x++ ) {
            if ( dp[m - 1][n - 1][x] ) {
                return x ;
            }
        }
        
        return -1 ;
    }
}