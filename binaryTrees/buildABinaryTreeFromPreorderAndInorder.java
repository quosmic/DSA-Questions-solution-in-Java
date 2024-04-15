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
    private int preindex = 0;

    public TreeNode build(int[] preorder, int[] inorder, int st, int end){
        if(st>end){
            return null;
        }
        TreeNode root= new TreeNode(preorder[preindex]);
        int num= preorder[preindex];
        preindex++;
        int idx1=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==num){
                idx1=i;
                break;
            }
        }
    root.left = build(preorder,inorder,st,idx1-1);
    root.right = build(preorder,inorder,idx1+1,end);
    return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     if(preorder.length==0){
         return null;
     }
     TreeNode root = build(preorder, inorder, 0, preorder.length-1);
     return root;   
    }
}