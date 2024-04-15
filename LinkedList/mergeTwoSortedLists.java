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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode ans= new ListNode(-1);
      ListNode list= ans;
      ListNode idx1= list1;
      ListNode idx2= list2;
        if(idx1==null&& idx2!=null){
            return idx2;
        }
      if(idx2==null&& idx1!=null){
          return idx1;
      }
      while(idx1!=null&&idx2!=null){
          if(idx1.val<idx2.val){
              list.next= idx1;
              idx1= idx1.next;
                list= list.next;
          }
        else{
            list.next= idx2;
            idx2= idx2.next;
            list= list.next;
        }
      }  
    while(idx1!=null){
       list.next= idx1;
        idx1= idx1.next;
        list= list.next; 
    }
    while(idx2!=null){
            list.next= idx2;
            idx2= idx2.next;
            list= list.next;        
    }
    return ans.next;
    }
}