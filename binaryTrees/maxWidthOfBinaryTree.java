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
    public class Specs{
        int level;
        TreeNode node;
        Specs(int l, TreeNode node){
            this.level=l;
            this.node= node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
       int ans=0;
        Queue<Specs> q= new LinkedList<>();
        q.add(new Specs(0,root));
        while(!q.isEmpty()){
            int size = q.size();// we are traversing the tree levelwise in a single go
                                // and we are updating the rh accordingly
            Specs curr= q.peek();
            int idx = curr.level;
            int lh = idx;
            int rh=lh;

            while(size!=0){
                Specs sp= q.remove();
                rh=sp.level;
                if(sp.node.left!=null){
                    q.add(new Specs(((sp.level * 2)+1),sp.node.left));// we are numbering each node
                }
                if(sp.node.right!=null){
                    q.add(new Specs(((sp.level * 2)+2),sp.node.right));
                }
            size--;
            }
                    ans= Math.max(ans, rh-lh+1);
        }
    return ans;
    }
}