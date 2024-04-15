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
    public int ans=0;
    public class Specs{
        boolean isBST;
        int size;
        int max;
        int min;
        Specs(boolean b, int s, int mx, int mn){
            this.isBST= b;
            this.size=s;
            this.max= mx;
            this.min= mn;
        }

    }
    public Specs maxi(TreeNode root){
        if(root== null){
            return new Specs(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
    Specs lft= maxi(root.left);
    Specs rgt= maxi(root.right);
    int size = root.val+ lft.size + rgt.size;
    int min = Math.min(lft.min, Math.min(root.val,rgt.min));
    int max = Math.max(rgt.max,Math.max(root.val,lft.max));
    if(lft.max>=root.val||rgt.min<=root.val){
        return new Specs(false,size,max,min);
    }
     if(lft.isBST && rgt.isBST){
        ans= Math.max(ans, size);
        return new Specs(true, size, max, min);
        
    }
    else return new Specs(false, size, max, min);
    }
    public int maxSumBST(TreeNode root) {
      
        Specs num = maxi(root);
        return ans;
    }
}