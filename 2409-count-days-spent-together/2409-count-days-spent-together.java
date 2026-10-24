class Solution {
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int startA = toDayOfYear(arriveAlice) ;
        int endA = toDayOfYear(leaveAlice) ;
        int startB = toDayOfYear(arriveBob) ;
        int endB = toDayOfYear(leaveBob) ;

        int start = Math.max(startA, startB) ;
        int end = Math.min(endA, endB) ;

        if ( start <= end ) {
            return end - start + 1 ;
        }
        return 0 ;
    }

    private int toDayOfYear(String date) {
        int m = Integer.parseInt(date.substring(0, 2)) ;
        int d = Integer.parseInt(date.substring(3, 5)) ;
        
        int total = d ;
        for ( int i = 0 ; i < m - 1 ; i++ ) {
            total += days[i] ;
        }
        return total ;
    }
}