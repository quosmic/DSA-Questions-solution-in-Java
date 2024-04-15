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

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
    int ans= -1;
        if(node==null){
            return -1;
        }
        TreeNode<Integer> curr= node;
    while(curr!=null){
        if(curr.data ==x){
            return x;
        }
    if(curr.data>x){
        ans= curr.data;
        curr=curr.left;
    }
    else if(curr.data<x){
        curr= curr.right;
    }
    }
    return ans;
    }
}
