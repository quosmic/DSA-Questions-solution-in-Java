class Solution{
      static class DisjointSet{
     List<Integer>parent = new ArrayList<>();
         List<Integer>rank = new ArrayList<>();
        
        public  DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                
            }
        }
    public  int par(int x){
        if(parent.get(x)==x){
            return x;
        }
    int node =par(parent.get(x));
         parent.set(x,node);
        return parent.get(x);
        
    }
    public  void union(int a, int b){
        int parA= par(a);
        int parB = par(b);
        if(parA==parB){
            return;
        }
        if (rank.get(parA) == rank.get(parB)) {
    parent.set(parB, parA);
    int rankA = rank.get(parA);
    rank.set(parA, rankA + 1);
}
        else if(rank.get(parA)<rank.get(parB)){
            parent.set(parA, parB);
        }
    else  parent.set(parB, parA);
        
    }
      }
	
static class Edge implements Comparable<Edge>{
        int wt;
        int src;
        int dest;
        Edge(int src ,int dest,int wt){
            this.src = src;
            this.dest= dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge p2 ){
            return this.wt-p2.wt;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	     List<Edge> edgeList = new ArrayList<Edge>();
	       for (int i = 0; i < E; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            Edge temp = new Edge(src, dest, weight);
            edgeList.add(temp);
        }
        DisjointSet ds = new DisjointSet(V);
        Collections.sort(edgeList);
        int sum=0;
        for(int i=0;i<edgeList.size();i++){
            Edge e = edgeList.get(i);
            int src = e. src;
            int dest = e.dest;
            int wt = e.wt;
            if(ds.par(src)!= ds.par(dest)){
                ds.union(src,dest);
                sum+=wt;
            }
        }
	return sum;
	    
	}
}