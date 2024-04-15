public class CyclicLinkedListRemove {
    public ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
       
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
           
            if(fast == slow) {
                fast = head;
                while(fast.next!==slow.next){
                    slow= slow.next;
                    fast = fast.next;
                }
            fast.next= null;
            return head;    
        }
    }
       
    return null;
}
     
}
