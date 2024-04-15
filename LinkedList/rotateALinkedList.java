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
    public ListNode rotateRight(ListNode head, int k) {
     ListNode curr= head;
     if(head==null||head.next==null){
         return head;
     }
     int length=1;
     while(curr.next!=null){
         curr= curr.next;
         length++;
     }   
    curr.next=head;
    int c=length-k%length;
    if(c==0){
        return head;
    }
    int i=0;
    while(i<c){
        curr= curr.next;
        i++;
    }
    head= curr.next;
    curr.next= null;
    return head;
    }
}