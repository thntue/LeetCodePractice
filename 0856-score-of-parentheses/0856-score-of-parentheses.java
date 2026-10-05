public class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                // Chỉ khi gặp cặp "()" nguyên tử mới tính điểm tại độ sâu hiện tại
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth; // Tương đương với 2^depth
                }
            }
        }

        return score;
    }
}