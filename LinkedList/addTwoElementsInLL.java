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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     int prev=0;
     ListNode ans= new ListNode(-1);
     ListNode curr= ans;
     ListNode idx1= l1;
     ListNode idx2= l2;
    int sum=-1;
     while(idx1!=null&&idx2!=null){
         sum=idx1.val+idx2.val+prev;
         if(sum>9){
             prev=sum/10;
             sum= sum%10;
         }
         else{
             prev=0;
         }
         ListNode n1= new ListNode(sum);
         curr.next= n1;
         idx1= idx1.next;
         idx2= idx2.next;
         curr= curr.next;
     }   
    while(idx1!=null){
         sum=idx1.val+prev;
         if(sum>9){
             prev=sum/10;
             sum= sum%10;
         }
         else{
             prev=0;
         }
         ListNode n1= new ListNode(sum);
         curr.next= n1;
         idx1= idx1.next;
         curr= curr.next;
     }  
    while(idx2!=null){
         sum=idx2.val+prev;
         if(sum>9){
             prev=sum/10;
             sum= sum%10;
         }
         else{
             prev=0;
         }
         ListNode n1= new ListNode(sum);
         curr.next= n1;
         idx2= idx2.next;
         curr= curr.next;
 
     }  
    if(prev!=0){
        ListNode n1= new ListNode(prev);
        curr.next= n1;
    }
    return ans.next;
    }
}