class Solution{
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

	static int minimumSpanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    pq.add(new Pair(0,0));
	    boolean vis[] = new boolean[V];
	    int sum=0;
	    while(!pq.isEmpty()){
           Pair curr = pq.remove();
           int val=  curr.val;
           int dist= curr.dist;
           if(vis[val]){
               continue;
           }
           vis[val]=true;
           sum+=dist;
           for(int i=0; i< adj.get(val).size();i++){
            int u = curr.val;
            int v = adj.get(curr.val).get(i).get(0);
            int wt = adj.get(curr.val).get(i).get(1);
           if(!vis[v]){
               pq.add(new Pair(v,wt));
           }
               
           }
       }
	return sum;
	    
	}
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	      ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<ArrayList<Integer>>());
		}
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int weight = edges[i][2];
			ArrayList<Integer> tmp1 = new ArrayList<Integer>();
			ArrayList<Integer> tmp2 = new ArrayList<Integer>();
			tmp1.add(v);
			tmp1.add(weight);

			tmp2.add(u);
			tmp2.add(weight);

			adj.get(u).add(tmp1);
			adj.get(v).add(tmp2);
		}
		return minimumSpanningTree(V, adj);
	}
}