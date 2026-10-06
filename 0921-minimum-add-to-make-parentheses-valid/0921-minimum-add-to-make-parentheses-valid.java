public class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0; 
        int insertions = 0; 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else {
                    insertions++;
                }
            }
        }
        return insertions + openCount;
    }
}