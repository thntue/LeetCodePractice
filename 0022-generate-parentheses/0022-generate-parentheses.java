import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] current = new char[2 * n];
        backtrack(result, current, 0, 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, char[] current, int index, int open, int close, int n) {
        if (index == 2 * n) {
            result.add(new String(current));
            return;
        }

        if (open < n) {
            current[index] = '(';
            backtrack(result, current, index + 1, open + 1, close, n);
        }

        if (close < open) {
            current[index] = ')';
            backtrack(result, current, index + 1, open, close + 1, n);
        }
    }
}