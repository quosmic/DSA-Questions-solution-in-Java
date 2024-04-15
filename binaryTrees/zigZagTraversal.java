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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> list= new ArrayList<>();
      Queue<TreeNode>q = new LinkedList<>();
       if (root == null) {
            return list;
        }
      q.add(root);
      q.add(null);
      List<Integer> list1= new ArrayList<>();
      while(!q.isEmpty()){
          TreeNode num= q.remove();
          if(num==null){
            if(list.size()%2!=0){
                Collections.reverse(list1);
                list.add(list1);
            }
            else{
            list.add(list1);
            }
              list1= new ArrayList<>();
              if(q.isEmpty()){
                  break;
              }
          else {
              q.add(null);

          }
          }
          else{
              list1.add(num.val);
      if(num.left!= null ){
          q.add(num.left);
      }
      if(num.right!= null){
          q.add(num.right);
      }
      }  
      }
   
    return list;  
    }
}