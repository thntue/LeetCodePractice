public class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack[++top] = i;
            } else if (c == ')') {
                int openIndex = stack[top--];
                pair[openIndex] = i;
                pair[i] = openIndex;
            }
        }

        StringBuilder result = new StringBuilder();
        int step = 1; 

        for (int i = 0; i < n; i += step) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = pair[i];  
                step = -step;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}