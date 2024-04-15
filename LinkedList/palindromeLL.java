/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null){
            next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
      if(head==null||head.next==null){
          return true;
      }  
    ListNode slow= head;
    ListNode fast= head.next;
    while(fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode mid= slow;
    mid.next= reverse(slow.next);
    ListNode idx1= head;
    ListNode idx2= mid.next;
    while(idx2!=null){
        if(idx1.val!=idx2.val){
            return false;
        }
        idx1=idx1.next;
        idx2=idx2.next;
    }
    
    return true;
    }
}