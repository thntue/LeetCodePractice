import java.util.Arrays;
import java.util.List;

public class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] sum1;  
    private long[] sum2;  
    private long[] lazy;  

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum1 = new long[4 * n];
        sum2 = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100005];
        Arrays.fill(last, -1);

        long totalAns = 0;

        for (int j = 0; j < n; j++) {
            int x = nums[j];
            int prev = last[x];

            update(1, 0, n - 1, prev + 1, j, 1);

            totalAns = (totalAns + sum2[1]) % MOD;

            last[x] = j;
        }

        return (int) totalAns;
    }

    public int sumCounts(List<Integer> nums) {
        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        return sumCounts(arr);
    }

    private void apply(int node, int l, int r, long val) {
        long len = r - l + 1;
        long v = val % MOD;

        sum2[node] = (sum2[node] + 2 * v % MOD * sum1[node] % MOD + len * (v * v % MOD) % MOD) % MOD;
        sum1[node] = (sum1[node] + len * v) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = l + (r - l) / 2;
            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void pushUp(int node) {
        sum1[node] = (sum1[node * 2] + sum1[node * 2 + 1]) % MOD;
        sum2[node] = (sum2[node * 2] + sum2[node * 2 + 1]) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }

        pushDown(node, l, r);
        int mid = l + (r - l) / 2;

        if (ql <= mid) {
            update(node * 2, l, mid, ql, qr, val);
        }
        if (qr > mid) {
            update(node * 2 + 1, mid + 1, r, ql, qr, val);
        }

        pushUp(node);
    }
}