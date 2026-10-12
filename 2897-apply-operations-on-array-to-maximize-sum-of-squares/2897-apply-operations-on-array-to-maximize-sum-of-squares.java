import java.util.List;

public class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] bitCount = new int[31]; 

        for (int num : nums) {
            for (int b = 0; b < 31; b++) {
                if (((num >> b) & 1) == 1) {
                    bitCount[b]++;
                }
            }
        }

        long totalSum = 0;

        for (int i = 0; i < k; i++) {
            long current = 0;
            for (int b = 0; b < 31; b++) {
                if (bitCount[b] > 0) {
                    current |= (1L << b);
                    bitCount[b]--;
                }
            }
            totalSum = (totalSum + (current * current) % MOD) % MOD;
        }

        return (int) totalSum;
    }
}