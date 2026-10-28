import java.util.HashMap ;
import java.util.HashSet ;
import java.util.Map ;
import java.util.Set ;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>() ;
        for ( int x : arr ) {
            count.put( x, count.getOrDefault( x, 0 ) + 1 ) ;
        }
        
        Set<Integer> set = new HashSet<>( count.values() ) ;
        return count.size() == set.size() ;
    }
}