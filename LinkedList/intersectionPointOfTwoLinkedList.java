/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
    ListNode curr1=headA;
    ListNode curr2= headB;
    while(curr1!=curr2){
        curr1= curr1.next;
        curr2=curr2.next;
        if(curr1==curr2){
            return curr1;
        }
        if(curr1==null){
            curr1=headB;
        }
        if(curr2==null){
            curr2=headA;
        }
    }
    return curr1;
    }
}