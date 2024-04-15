// User function Template for Java

// function Template for Java

// FUNCTION CODE
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
} */

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node== null){
            return;
        }
    Node n1= node.left;
    Node n2= node.right;
    mirror(n1);
    mirror(n2);
    Node temp= n1;
    Node temp2= n2;
    node.left= n2;
    node.right=n1;
        
    }
}