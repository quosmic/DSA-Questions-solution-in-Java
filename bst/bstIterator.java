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
class BSTIterator {
      Stack<TreeNode> s= new Stack<>();
    public BSTIterator(TreeNode root) {

      pushAll(s,root);  
    }
    
    public int next() {
        TreeNode temp= s.pop();
        pushAll(s,temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    public void pushAll(Stack<TreeNode> s, TreeNode root){
        TreeNode curr= root;
        while(curr!=null){
            s.push(curr);
            curr= curr.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */