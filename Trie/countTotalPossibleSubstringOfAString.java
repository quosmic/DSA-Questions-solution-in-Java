
import java.util.ArrayList;

public class Solution 
{
	public static class Node{
		Node[] children= new Node[26];
		boolean eow;
	Node(){
		for(int i=0;i<26;i++){
			children[i]= null;
					}
	}
	}
	public static Node root= new Node();
	public static void insert(String str){
		int len= str.length();
		Node curr= root;
		for(int i=0;i<len;i++){
			int idx= str.charAt(i)-'a';
			if(curr.children[idx]==null){
				curr.children[idx]= new Node();
			}
		curr= curr.children[idx];
		}
	curr.eow= true;
	}
	public static int countNodes(Node root){
		if(root==null){
			return 0;
		}
		int count =0;
		for(int i=0;i<26;i++){
			if(root.children[i]!=null){
				count+=countNodes(root.children[i]);
			}
		}
	return 1+ count;
	}
	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		root= new Node();
		for(int i=0;i<s.length();i++){
			insert(s.substring(i));
		}
	return countNodes(root);
	}
}