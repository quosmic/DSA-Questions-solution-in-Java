class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
    int [] dist = new int[V];
    for(int i=0;i<V;i++){
        if(i!=S){
            dist[i]= 100000000;
        }
    }
    for(int i=0; i<V-1;i++){
        for(int j=0;j<edges.size();j++){
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);
                if(dist[u]!=100000000 && dist[v]>dist[u]+wt){
                    dist[v]=dist[u]+wt;
                }

        }
    }
          for(int j=0;j<edges.size();j++){
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);
                if(dist[u]!=100000000 && dist[v]>dist[u]+wt){
                    int temp[] = new int[1];
                    Arrays.fill(temp,-1);
                    return temp;
                }

        }
        return dist;
    }
}
