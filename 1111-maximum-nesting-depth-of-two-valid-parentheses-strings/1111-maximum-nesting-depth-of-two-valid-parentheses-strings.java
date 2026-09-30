public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                ans[i] = depth % 2;
                depth++;
            } else {
                depth--;
                ans[i] = depth % 2;
            }
        }

        return ans;
    }
}