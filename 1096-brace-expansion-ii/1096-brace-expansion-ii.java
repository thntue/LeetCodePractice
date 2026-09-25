import java.util.*;

public class Solution {
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        index = 0;
        Set<String> resultSet = parseExpression(expression);
        
        List<String> sortedResult = new ArrayList<>(resultSet);
        Collections.sort(sortedResult);
        return sortedResult;
    }

    private Set<String> parseExpression(String s) {
        Set<String> result = new HashSet<>();
        result.addAll(parseTerm(s));

        while (index < s.length() && s.charAt(index) == ',') {
            index++; 
            result.addAll(parseTerm(s));
        }

        return result;
    }

    private Set<String> parseTerm(String s) {
        Set<String> result = new HashSet<>();
        result.add(""); 

        while (index < s.length() && s.charAt(index) != ',' && s.charAt(index) != '}') {
            Set<String> factor = parseFactor(s);
            Set<String> nextResult = new HashSet<>();
            for (String a : result) {
                for (String b : factor) {
                    nextResult.add(a + b);
                }
            }
            result = nextResult;
        }

        return result;
    }
    private Set<String> parseFactor(String s) {
        if (s.charAt(index) == '{') {
            index++; 
            Set<String> result = parseExpression(s);
            index++; 
            return result;
        } else {
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && Character.isLowerCase(s.charAt(index))) {
                sb.append(s.charAt(index));
                index++;
            }
            Set<String> result = new HashSet<>();
            result.add(sb.toString());
            return result;
        }
    }
}