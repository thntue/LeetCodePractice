public class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0; 
        int cmax = 0; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmax--;
                cmin = Math.max(cmin - 1, 0);
            } else if (c == '*') {
                cmax++;                       
                cmin = Math.max(cmin - 1, 0); 
            }

            if (cmax < 0) {
                return false;
            }
        }
        return cmin == 0;
    }
}