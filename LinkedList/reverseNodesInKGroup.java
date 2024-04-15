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
    public ListNode reverse(ListNode head, int k, int length){
        if(length<k){
            return head;
        }
        ListNode curr=head;
        ListNode prev= null;
        ListNode next = null;
        int count=1;
        while(curr!=null&& count<=k){
            next= curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
            count++;
        }
    if(curr!=null){
    head.next= reverse(curr,k,length-k);
    }
    return prev; 
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr= head;
        ListNode prev= head;
        ListNode prev1=null;
        int size=0;
        while(curr!=null){
                size++;
                curr=curr.next;
        }
    return reverse(head,k,size);
    }
}