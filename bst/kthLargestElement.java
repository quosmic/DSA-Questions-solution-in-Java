/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
     public void getInorder(Node root, ArrayList<Integer>list){
        if(root==null){
            return;
        }
    getInorder(root.left,list);
    list.add(root.data);
    getInorder(root.right,list);
    }
    public int kthLargest(Node root,int K)
    {
        //Your code here
        ArrayList<Integer> list= new ArrayList<>();
        getInorder(root,list);
        int n=list.size()-K;
        return list.get(n);
    }
}