import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int ans= Integer.MIN_VALUE;
        if(root==null){
            return ans;
        }
        TreeNode<Integer> curr= root;
    while(curr!=null){
        if(curr.data ==X){
            return X;
        }
    if(curr.data>X){
        curr=curr.left;
    }
    else if(curr.data<X){
        ans= Math.max(ans,curr.data);
        curr= curr.right;
    }
    }
    return ans;
    }
}