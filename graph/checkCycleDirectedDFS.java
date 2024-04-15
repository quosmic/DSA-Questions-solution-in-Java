class Solution {
    // Function to detect cycle in a directed graph.
    public static boolean cycleDetection(int n, ArrayList < ArrayList < Integer >> edges, int curr, boolean vis[], boolean stack[]){
    vis[curr] = true;
    stack[curr] = true;
    for(int i = 0; i<edges.get(curr).size(); i++){
      int num = edges.get(curr).get(i);
      if(stack[num]){
        return true;
      }
      else if(!vis[num]){
        boolean response = cycleDetection(n, edges, num, vis, stack);
        if(response){
        return true;
        }
      }
    }
  stack[curr]=false;
  return false;
  }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
    boolean stack[] = new boolean[V];
    for(int i=1;i<V;i++){
      if(!vis[i]){
        if(cycleDetection(V,adj,i,vis,stack)){
          return true;
        }
      }
    }
  return false;
  }
    
}