class Solution {
    public boolean isBipar(int[][] graph, boolean vis[], int curr, int colour[]){
        Queue<Integer> q= new LinkedList<>();
        vis[curr] = true;
        q.add(curr);
        while(!q.isEmpty()){
            int num = q.remove();
            for(int i =0;i<graph[num].length;i++){
                if(!vis[graph[num][i]]){
                    vis[graph[num][i]]= true;
                    colour[graph[num][i]]= colour[num]==0?1:0;
                    q.add(graph[num][i]);
                }
            if(colour[graph[num][i]]== colour[num]){
                return false;
            }
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