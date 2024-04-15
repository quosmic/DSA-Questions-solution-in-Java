/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serDFS(TreeNode root){
        if(root==null){
            return "N";
        }
    String lft= serDFS(root.left);
    String rgt= serDFS(root.right);
    return root.val+","+lft+","+rgt;
    }
    public String serialize(TreeNode root) {
       if(root==null){
           return "";
       } 
    return serDFS(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode desDFS(String[] data, int[] idx){
        if(data[idx[0]].equals("N")){
            idx[0]++;
            return null; 
        }
    TreeNode root = new TreeNode(Integer.parseInt(data[idx[0]]));
    idx[0]++;
    root.left= desDFS(data, idx);
    root.right = desDFS(data, idx);
    return root;
    }
    public TreeNode deserialize(String data) {
        if(data==""){
            return null;
        }
        String[] datas= data.split(",");
        int[] idx= {0};
        return desDFS(datas, idx);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));