class Solution {
    public List<Integer> checkForSafeNodes(ArrayList<Integer> graphing[], 
    ArrayList<Integer> terminalNodes) {
     List<Integer> safeNodes = new ArrayList<>();
     boolean vis[] = new boolean[graphing.length];
     boolean stack[] = new boolean[graphing.length];
     for(int i=0;i<graphing.length;i++){
        if(terminalNodes.contains(i)){
            safeNodes.add(i);
     } 
     else if(!isCycle_Util(graphing, i, vis, stack)){
        safeNodes.add(i); 
     }
     }
    return safeNodes; 
    }
    public static boolean isCycle_Util(ArrayList<Integer> graph[], int curr, boolean vis[], boolean stack[]){
         vis[curr] = true;
        stack[curr] = true;

        for(int node : graph[curr]){
            if(stack[node]){
                return true;
            }
            if (!vis[node] && isCycle_Util(graph, node, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int vertices = graph.length;
       ArrayList<Integer>[] graphing = new ArrayList[vertices];
       for(int i=0;i<vertices;i++){
            graphing[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<vertices;i++){
            for(int j=0;j<graph[i].length;j++) {
                graphing[i].add(graph[i][j]);
            }
        }  
    ArrayList<Integer> terminalNodes = new ArrayList<>();
    for(int i=0;i<graphing.length;i++){
      ArrayList<Integer> nextNodes = graphing[i];
      if(nextNodes.size() == 0){
          terminalNodes.add(i);
      }  
    }
    List<Integer> safeNodes = checkForSafeNodes(graphing, terminalNodes);
    return safeNodes;
    }
}
