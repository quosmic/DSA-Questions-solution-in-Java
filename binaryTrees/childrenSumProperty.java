/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution {
    public static boolean isParentSum(Node root) {
        // Write your code here.
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
    if(root.left!=null&& root.right==null&& root.data==root.left.data){
        if(isParentSum(root.left)){
            return true;
        }
    }
      if(root.right!=null&& root.left==null&& root.data==root.right.data){
        if(isParentSum(root.right)){
            return true;
        }
    }
    if(root.right!=null&& root.left!=null && root.data==(root.left.data+root.right.data)){
        if(isParentSum(root.left)&&isParentSum(root.right)){
            return true;
        }
    }
    return false;
    }
}