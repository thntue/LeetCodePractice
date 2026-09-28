public class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        for (int i =  0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                depth++;
                if(depth > maxDepth){
                    maxDepth = depth;
                }
            } else if (c==')'){
                depth--;
            }
        }
        return maxDepth;
    }
}