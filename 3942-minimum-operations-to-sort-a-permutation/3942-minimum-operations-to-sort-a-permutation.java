class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length ;
        if ( n <= 1 ) {
            return 0 ;
        }
        
        boolean isInc = true ;
        boolean isDec = true ;
        int idxZero = 0 ;
        
        for ( int i = 0 ; i < n ; i++ ) {
            if ( nums[i] == 0 ) {
                idxZero = i ;
            }
            if ( nums[(i + 1) % n] != (nums[i] + 1) % n ) {
                isInc = false ;
            }
            if ( nums[(i + 1) % n] != (nums[i] - 1 + n) % n ) {
                isDec = false ;
            }
        }
        
        if ( !isInc && !isDec ) {
            return -1 ;
        }
        
        int ans = Integer.MAX_VALUE ;
        if ( isInc ) {
            if ( idxZero == 0 ) {
                ans = 0 ;
            } else {
                ans = Math.min( ans, idxZero ) ;
                ans = Math.min( ans, (n - idxZero) + 2 ) ;
            }
        }
        if ( isDec ) {
            int op1 = ((idxZero + 1) % n) + 1 ; 
            int op2 = (n - 1 - idxZero) + 1 ;  
            ans = Math.min( ans, Math.min( op1, op2 ) ) ;
        }
        
        return ans ;
    }
}