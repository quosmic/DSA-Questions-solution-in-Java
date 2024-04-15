class Solution
{
    static class Pair implements Comparable<Pair>{
        int val;
        int dist;
        Pair(int v, int d){
            this.val=v;
            this.dist=d; 
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
        
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
       int dist[] = new int[V];
       pq.add(new Pair(S,0));
       Arrays.fill(dist, Integer.MAX_VALUE);
       boolean vis[] = new boolean[V];
       dist[S] = 0;
       while(!pq.isEmpty()){
           Pair curr = pq.remove();
           vis[curr.val]=true;
           for(int i=0; i< adj.get(curr.val).size();i++){
            int u = curr.val;
            int v = adj.get(curr.val).get(i).get(0);
            int wt = adj.get(curr.val).get(i).get(1);
           if(!vis[v] && (dist[u]+wt)<dist[v]){
               dist[v]=dist[u]+wt;
               pq.add(new Pair(v,dist[v]));
           }
               
           }
       }
    return dist;
    }
}
