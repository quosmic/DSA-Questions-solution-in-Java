class Solution {
     public boolean isBipar(int[][] graph, boolean vis[], int num, int colour[]){
        vis[num] = true;
        for(int i =0;i<graph[num].length;i++){
            if(!vis[graph[num][i]]){
                    colour[graph[num][i]]= colour[num]==0?1:0;
                 if(!isBipar(graph,vis,graph[num][i],colour)){
                     return false;
                 };
                }
            if(colour[graph[num][i]]== colour[num]){
                return false;
            }
            }

    return true;
    }
    public boolean isBipartite(int[][] graph) {
           int V = graph.length;
        boolean vis[] = new boolean[V];
        int colour[] = new int[V];
        for(int i=0;i<V;i++){
            colour[i]=-1;
        }
        for(int i = 0;i<V; i++){
            if(!vis[i]){
                colour[i] = 0;
                if(!isBipar(graph, vis, i, colour)){
                    return false;
                }
            }
        }
    return true;
    }
}