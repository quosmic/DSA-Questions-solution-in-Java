 /*********************************************************

 Following is the TreeNode structure:
 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Solution {
    public static class Pair{
        int num;
        TreeNode node;
        Pair(int n, TreeNode tree){
            this.num= n;
            this.node = tree;
        }
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> ino = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<Pair> s= new Stack<>();
        s.push(new Pair(1,root));
        while(!s.isEmpty()){
            Pair curr = s.pop();
            if(curr.num==1){
                pre.add(curr.node.data);
                curr.num++;
                s.push(curr);
                if(curr.node.left!=null){
                    s.push(new Pair(1,curr.node.left));
                }
            }
        else if(curr.num==2){
                ino.add(curr.node.data);
                curr.num++;
                s.push(curr);
                if(curr.node.right!=null){
                    s.push(new Pair(1,curr.node.right));
                }
            }
        else{
            post.add(curr.node.data);
        }
        }
                  list.add(ino);
     list.add(pre);
     list.add(post);   
    return list;
    }
}