public class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] count = new int[100001]; 
        int maxDiff = 0;
        long totalK = (long) k1 + k2;

        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            count[d]++;
            if (d > maxDiff) {
                maxDiff = d;
            }
        }

        for (int d = maxDiff; d > 0 && totalK > 0; d--) {
            if (count[d] == 0) {
                continue;
            }

            if (totalK >= count[d]) {
                totalK -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                count[d] -= (int) totalK;
                count[d - 1] += (int) totalK;
                totalK = 0;
                break;
            }
        }

        long minSquaredSum = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                minSquaredSum += (long) count[d] * (long) d * d;
            }
        }

        return minSquaredSum;
    }
}