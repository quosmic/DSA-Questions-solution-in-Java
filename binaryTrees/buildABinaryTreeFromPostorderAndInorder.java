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
    private int preindex;
     public TreeNode build(int[] postorder, int[] inorder, int istart, int iend, Map<Integer, Integer> map){
        if(istart>iend||inorder.length!=postorder.length||preindex<0){
            return null;
        }
        TreeNode root= new TreeNode(postorder[preindex]);
        int num2=postorder[preindex];// root
        int idx= map.get(num2);
        preindex--;

    root.right = build(postorder,inorder,idx+1,iend,map);    
    root.left = build(postorder,inorder,istart,idx-1, map);

    return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      if(postorder.length==0||inorder.length==0){
         return null;
     }
     Map<Integer,Integer> map= new HashMap<>();
     for(int i=0;i<inorder.length;i++){
         map.put(inorder[i],i);
     }
     preindex= inorder.length-1;
     TreeNode root = build(postorder, inorder, 0, inorder.length-1, map);
     return root;   
    }
}