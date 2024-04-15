  /* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
  ArrayList<Integer> leftView(Node root)
    {
       
       
         ArrayList<Integer> result = new ArrayList<>();
        leftViewRecursive(root, 1, result);
        return result;
    }

    private void leftViewRecursive(Node node, int level, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

  
               if (level > result.size()) {
                 result.add(node.data);
        }


        leftViewRecursive(node.left, level + 1, result);
        leftViewRecursive(node.right, level + 1, result);
    }
}