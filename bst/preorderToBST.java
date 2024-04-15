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
    public TreeNode createBST(TreeNode root, int num){
        if(root==null){
            return new TreeNode(num);
        }
    if(root.val>num){
        root.left= createBST(root.left, num);
    }
    else{
    root.right = createBST(root.right,num);
    }
    return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
    TreeNode root= null;
    for(int i=0;i<preorder.length;i++){
        root= createBST(root,preorder[i]);
    }    
    return root;
    }
}