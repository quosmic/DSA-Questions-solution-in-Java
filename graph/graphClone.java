/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution {
   public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        return cloneIt(node, map);
    }

    private Node cloneIt(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<>());
        map.put(node, clonedNode);

        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneIt(neighbor, map));
        }

        return clonedNode;
    }
}