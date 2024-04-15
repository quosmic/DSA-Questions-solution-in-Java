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
    public void flatten(TreeNode root) {
       if(root==null){
           return;
       }
    TreeNode t1= root.left;
    TreeNode t2= root.right;
    flatten(t1);
    flatten(t2);
    TreeNode curr= root.left;
    root.left=null;
    TreeNode curr2= root.right;
    root.right= curr;
    TreeNode current=root;
    while(current.right!=null){
        current= current.right;
    }
    current.right= curr2;
    }
}