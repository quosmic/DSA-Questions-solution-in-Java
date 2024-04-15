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
    public boolean validity(TreeNode root, TreeNode min, TreeNode max){
        if(root==null){
            return true;
        }
        if((min!=null && root.val<=min.val)||(max!=null && root.val>=max.val)){
            return false;
        }
    if(validity(root.left,min,root) && validity(root.right,root,max)){
        return true;
    }
    else return false;
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
    return validity(root,null,null);
    }
}