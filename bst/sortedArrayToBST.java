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
    public TreeNode constructBST(int[] num, int start, int end){
        if(start>end){
            return null;
        }
    int mid= (start+end)/2;
    TreeNode root= new TreeNode(num[mid]);
    root.left= constructBST(num,start,mid-1);
    root.right= constructBST(num,mid+1,end);
    return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
      return constructBST(nums,0,nums.length-1);  
    }
}