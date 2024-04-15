/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSym(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        
    if(t1!=null&&t2!=null&&t1.val==t2.val){
        if(isSym(t1.left,t2.right)&&isSym(t1.right,t2.left)){
            return true;
        }
    }
    return false;
    }
    public boolean isSymmetric(TreeNode root) {
       if(root==null||(root.left==null && root.right==null)){
           return true;
       } 
    return isSym(root.left,root.right);
    }
}