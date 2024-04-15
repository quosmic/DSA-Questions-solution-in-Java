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
    public ListNode removeNthFromEnd(ListNode head, int n) {
     int size=0;
     if(head==null||n<0){
         return null;
     }   
    if(n==0){
        return head;
    }
    ListNode curr=head;
    while(curr!=null){
        curr= curr.next;
        size++;
    }
    curr=head;
    if(n>size){
        return null;
    }
    if(n==size){
        return head.next;
    }
    int i=0;
    while(i<size-n-1){
        curr= curr.next;
        i++;
    }
    curr.next= curr.next.next;
    
    return head;
    }
}