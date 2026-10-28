class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        
        // Tim diem bat dau cua nua sau
        while ( fast != null && fast.next != null ) {
            slow = slow.next ;
            fast = fast.next.next ;
        }
        
        // Dao nguoc nua sau danh sach
        ListNode prev = null ;
        ListNode cur = slow ;
        while ( cur != null ) {
            ListNode next = cur.next ;
            cur.next = prev ;
            prev = cur ;
            cur = next ;
        }
        
        // Tinh tong cap sinh doi lon nhat
        int maxSum = 0 ;
        ListNode first = head ;
        ListNode second = prev ;
        
        while ( second != null ) {
            maxSum = Math.max( maxSum, first.val + second.val ) ;
            first = first.next ;
            second = second.next ;
        }
        
        return maxSum ;
    }
}