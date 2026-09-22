import java.util.Arrays;
public class Solution {

    private static class Node {
        final int[] prefixCounts;

        int totalProduct;

        Node(int k) {
            this.prefixCounts = new int[k];
            this.totalProduct = 1 % k;
        }
    }

    private static class SegmentTree {
        private final int n;
        private final int k;
        private final Node[] tree;

        public SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.tree = new Node[4 * n];
            build(0, 0, n - 1, nums);
        }

        private Node merge(Node left, Node right) {
            if (left == null) return right;
            if (right == null) return left;

            Node parent = new Node(k);
            parent.totalProduct = (left.totalProduct * right.totalProduct) % k;
            for (int r = 0; r < k; r++) {
                parent.prefixCounts[r] = left.prefixCounts[r];
            }
            int leftProd = left.totalProduct;
            for (int r = 0; r < k; r++) {
                if (right.prefixCounts[r] > 0) {
                    int combinedRemainder = (leftProd * r) % k;
                    parent.prefixCounts[combinedRemainder] += right.prefixCounts[r];
                }
            }

            return parent;
        }

        private void build(int treeIndex, int lo, int hi, int[] nums) {
            if (lo == hi) {
                tree[treeIndex] = new Node(k);
                int val = nums[lo] % k;
                tree[treeIndex].totalProduct = val;
                tree[treeIndex].prefixCounts[val] = 1;
                return;
            }

            int mid = lo + (hi - lo) / 2;
            int leftChild = 2 * treeIndex + 1;
            int rightChild = 2 * treeIndex + 2;

            build(leftChild, lo, mid, nums);
            build(rightChild, mid + 1, hi, nums);

            tree[treeIndex] = merge(tree[leftChild], tree[rightChild]);
        }
        public void update(int index, int value) {
            update(0, 0, n - 1, index, value % k);
        }

        private void update(int treeIndex, int lo, int hi, int index, int value) {
            if (lo == hi) {
                Arrays.fill(tree[treeIndex].prefixCounts, 0);
                tree[treeIndex].totalProduct = value;
                tree[treeIndex].prefixCounts[value] = 1;
                return;
            }

            int mid = lo + (hi - lo) / 2;
            int leftChild = 2 * treeIndex + 1;
            int rightChild = 2 * treeIndex + 2;

            if (index <= mid) {
                update(leftChild, lo, mid, index, value);
            } else {
                update(rightChild, mid + 1, hi, index, value);
            }

            tree[treeIndex] = merge(tree[leftChild], tree[rightChild]);
        }

        public Node query(int queryLeft, int queryRight) {
            return query(0, 0, n - 1, queryLeft, queryRight);
        }

        private Node query(int treeIndex, int lo, int hi, int queryLeft, int queryRight) {
            if (queryLeft <= lo && hi <= queryRight) {
                return tree[treeIndex];
            }

            int mid = lo + (hi - lo) / 2;
            int leftChild = 2 * treeIndex + 1;
            int rightChild = 2 * treeIndex + 2;
            if (queryRight <= mid) {
                return query(leftChild, lo, mid, queryLeft, queryRight);
            }
            if (queryLeft > mid) {
                return query(rightChild, mid + 1, hi, queryLeft, queryRight);
            }
            Node leftResult = query(leftChild, lo, mid, queryLeft, queryRight);
            Node rightResult = query(rightChild, mid + 1, hi, queryLeft, queryRight);
            return merge(leftResult, rightResult);
        }
    }
 
     
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        SegmentTree segmentTree = new SegmentTree(nums, k);
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            segmentTree.update(index, value);
            Node rangeResult = segmentTree.query(start, n - 1);
            result[i] = rangeResult.prefixCounts[x];
        }

        return result;
    }
    public int[] findXValue(int[] nums, int k, int[][] queries) {
        return resultArray(nums, k, queries);
    }
}