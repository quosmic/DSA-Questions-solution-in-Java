import java.util.* ;
import java.io.*; 
/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/

public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
		List<Integer> ans= new ArrayList<>();
		if(root==null){
			return ans;
		}
		TreeNode node= root;
		while(node!=null){
			if(node.left==null){
				ans.add(node.data);
				node= node.right;
			}
			else{
				TreeNode pre= pref(node);
				if(pre.right==null){
					pre.right= node;
					ans.add(node.data);
					node= node.left;
				}
				else{
					pre.right=null;
					node=node.right;
				}
			}
		}
		return ans;
	}
	public static TreeNode pref(TreeNode root){
		TreeNode node= root.left;
		while(node.right!=null&&node.right!=root){
			node= node.right;
		}
		return node;
	}
}