/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
    Node curr= head;
    while(curr!=null){//insertion
        Node newNode= new Node(curr.val);
        Node next= curr.next;
        curr.next= newNode;
        newNode.next= next;
        curr=next;
    }
    curr= head;
    while(curr!=null){
        if(curr.random!=null){
        curr.next.random= curr.random.next;
        }
        curr= curr.next.next;

    }
    Node ans= new Node(-1);
    Node cur1= ans;
    curr= head;
    while(curr!=null){
        Node next= curr.next.next;
        Node cur2= curr.next;
        cur1.next=cur2;
        cur1=cur2;
        curr.next=next;
        curr=next;
    }
    return ans.next;
    }
}