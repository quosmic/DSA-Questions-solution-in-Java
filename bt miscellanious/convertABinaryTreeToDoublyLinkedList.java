import java.util.* ;
import java.io.*; 

/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution {
	public static void getInorder(BinaryTreeNode<Integer> root, ArrayList<BinaryTreeNode<Integer>> list ){
		if(root==null){
			return;
		}
	getInorder(root.left, list);
	list.add(root);
	getInorder(root.right, list);
	}
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		// Write your code here
	ArrayList<BinaryTreeNode<Integer>> list= new ArrayList<>();
	getInorder(root, list);
	if(list.size()==0){
		return null;
	}
	BinaryTreeNode<Integer> root1= new BinaryTreeNode<Integer>(list.get(0).data);
	root1.left= null;
	BinaryTreeNode<Integer> curr= root1;
	BinaryTreeNode<Integer> prev= null;
	for(int i=1;i<list.size();i++){
		curr.right=new BinaryTreeNode<Integer> (list.get(i).data);
		curr.left= prev;
		prev= curr;
		curr=curr.right;
	}
	return root1;
	}
	

}