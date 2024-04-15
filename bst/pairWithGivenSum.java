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
    public void getInorder(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
    getInorder(root.left,list);
    list.add(root.val);
    getInorder(root.right,list);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer>list= new ArrayList<>();
        getInorder(root,list);
        int[] dp= new int[list.size()];
        int i=0;
        int j= list.size()-1;
        while(i<j){
        if(list.get(j)+list.get(i) >k){
            j--;
        }
        else if(list.get(i)+list.get(j)==k){
            return true;
        }
       
        else{
            i++;
            
        }
        }
    return false;
    }
}