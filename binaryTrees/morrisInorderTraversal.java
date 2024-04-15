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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        TreeNode node= root;
        while(node!=null){
            if(node.left==null){
                ans.add(node.val);
                node= node.right;
            }
        else{
            TreeNode pre= findPre(node);
            if(pre.right==node){
                pre.right=null;
                ans.add(node.val);
                node= node.right;
            }
            else{
                pre.right=node;
                node=node.left;
            }
        }
        }
        return ans;
    }
    
    public TreeNode findPre(TreeNode root){
        TreeNode node= root.left;
        while(node.right!=null&&node.right!=root){
            node= node.right;
        }
    return node;
    }
}