public class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if ((long) num * 9 < sum) {
            return "";
        }

        char[] result = new char[num];
        int nines = sum / 9;
        int rem = sum % 9;
        int idx = 0;

        for (int i = 0; i < nines; i++) {
            result[idx++] = '9';
        }

        if (rem > 0) {
            result[idx++] = (char) ('0' + rem);
        }

        while (idx < num) {
            result[idx++] = '0';
        }

        return new String(result);
    }
}