/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.*;

public class Solution {
    public static void getLeft(TreeNode root, List<Integer> list){
        if(root==null||(root.left==null && root.right==null)){
            return;
        }
    list.add(root.data);
    if(root.left!=null){
        getLeft(root.left, list);
    }
    else{
        getLeft(root.right,list);
    }
    }
    public static void getLeaves(TreeNode root, List<Integer>list){
        if(root==null){
            return;
        }
    if(root.left==null && root.right==null){
        list.add(root.data);
        return;
    }
    getLeaves(root.left,list);
    getLeaves(root.right,list);
    }
    public static void getRight(TreeNode root, List<Integer> list){
        if(root==null||(root.left==null && root.right==null)){
            return;
        }
    if(root.right!=null){
        getRight(root.right, list);
    }
    else{
        getRight(root.left, list);
    }
    list.add(root.data);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> list= new ArrayList<>();
        if(root==null){
            return list;
        }
        list.add(root.data);
        getLeft(root.left, list);
        
        getLeaves(root, list);
        getRight(root.right, list);
    return list;
    }
}