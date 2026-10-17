import java.util.Arrays;

public class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        long[] packed = new long[n];

        for (int i = 0; i < n; i++) {
            long dSum = getDigitSum(nums[i]);
            packed[i] = (dSum << 48) | ((long) nums[i] << 18) | i;
        }

        Arrays.sort(packed);

        int[] target = new int[n];
        final int MASK_18 = (1 << 18) - 1;
        for (int k = 0; k < n; k++) {
            target[k] = (int) (packed[k] & MASK_18);
        }

        boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || target[i] == i) {
                continue;
            }

            int cycleLength = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = target[curr];
                cycleLength++;
            }

            if (cycleLength > 1) {
                totalSwaps += cycleLength - 1;
            }
        }

        return totalSwaps;
    }

    private int getDigitSum(int val) {
        int sum = 0;
        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }
}