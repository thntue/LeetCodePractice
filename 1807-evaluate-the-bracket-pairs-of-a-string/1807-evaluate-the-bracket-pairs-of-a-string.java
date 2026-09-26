import java.util.*;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;

        while (i < n) {
            char c = s.charAt(i);

            if (c == '(') {
                int start = i + 1;
                while (i < n && s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(start, i);
                result.append(map.getOrDefault(key, "?"));
            } else {
                result.append(c);
            }
            i++;
        }

        return result.toString();
    }
}