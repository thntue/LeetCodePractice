public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int n = s.length();
        int cycle = 2 * numRows - 2; 
        StringBuilder sb = new StringBuilder(n);

        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < n; i += cycle) {
                sb.append(s.charAt(i));
                int diagonalIdx = i + cycle - 2 * r;
                if (r > 0 && r < numRows - 1 && diagonalIdx < n) {
                    sb.append(s.charAt(diagonalIdx));
                }
            }
        }

        return sb.toString();
    }
}