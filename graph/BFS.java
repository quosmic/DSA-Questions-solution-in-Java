class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
      ArrayList<Integer> result = new ArrayList<>();
     Queue<Integer>q = new LinkedList<>();
     boolean vis[]= new boolean[V];
     q.add(0);
    vis[0] = true;

     while(!q.isEmpty()){
         int num = q.remove();
         result.add(num);
         ArrayList<Integer> list = adj.get(num);
         for(int i=0;i<list.size();i++){
             int dest = list.get(i);
             if(!vis[dest]){
             q.add(dest);
             vis[dest]=true;
             }
         }
     }
    return result;
        
    }
}