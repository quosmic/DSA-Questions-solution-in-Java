/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.*;
import java.util.Set;
public class Solution {
    public static void rootToLeaf(BinaryTreeNode root, String s, List<String> set){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
                        set.add(s+root.data);

            return;
        }
        
   
    s+=root.data+" ";
    if(root.left!=null)
    rootToLeaf(root.left, s, set);
    rootToLeaf(root.right, s, set);
    
    }
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
    List<String> list=new ArrayList<>();
    if(root==null){
        return list;
    }
    rootToLeaf(root, "", list);
    
    return list;
    }
}