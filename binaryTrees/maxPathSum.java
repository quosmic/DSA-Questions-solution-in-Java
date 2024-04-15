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
    private int ans;
    public int summer(TreeNode root){
        if(root==null){
          return 0;
      }  
    int lh= Math.max(0,summer(root.left));
    int rh= Math.max(0,summer(root.right));
     ans= Math.max(ans,root.val+ lh+rh);
    return Math.max(root.val+ lh, root.val+ rh);
    }

    public int maxPathSum(TreeNode root) {
      ans= Integer.MIN_VALUE;
      int num = summer(root);
      return ans;
    }
}