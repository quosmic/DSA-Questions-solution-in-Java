
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
      static class Edge implements Comparable<Edge>{
        int s;
        int d;
        int t;

        Edge(int src, int dst, int type) {
            s = src;
            d = dst;
            t = type;
        }
        @Override
        public int compareTo(Edge e) {
            if(e.t != this.t)
                return e.t - this.t;

            if(e.d != this.d)
                return e.d - this.d;

            return e.s - this.s;
        }

        @Override
        public boolean equals(Object o) {
            Edge e = ((Edge)o);
            return e.t == this.t &&
                    (
                            (e.s == this.s && e.d == this.d) ||
                                    (e.s == this.d && e.d == this.s)
                    );
        }

        @Override
        public int hashCode() {
            return t * s * d;
        }
    }

    static void createGraph(ArrayList<Edge> agraph[], int[][] edges) {
        for(int i=0; i<agraph.length; i++) {
            agraph[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length;i++){
                agraph[edges[i][1]-1].add(new Edge(edges[i][1]-1,edges[i][2]-1,edges[i][0]));
                agraph[edges[i][2]-1].add(new Edge(edges[i][2]-1,edges[i][1]-1,edges[i][0]));
        }//Alice and Bob graph created.
    }
    public static Set<Edge> primAlgo(ArrayList<Edge> graph[], int type) {
        Set<Edge> mst = new HashSet<>();
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0,-1));

        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.d]) {
                vis[curr.d] = true;
                if(curr.t != -1)
                    mst.add(curr);
                for(int i=0; i<graph[curr.d].size(); i++) {
                    Edge e = graph[curr.d].get(i);
                    if(!vis[e.d]&& (e.t == 3 || e.t == type)) {
                        pq.add(e);
                    }
                }
            }
        }
        for(int i = 0; i<vis.length; i++){
            if(!(vis[i])){
            return new HashSet<>();           
            }
        }
        return mst;
    }
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        ArrayList<Edge> agraph[] = new ArrayList[n];
        createGraph(agraph, edges);
        Set<Edge> aliceMST =primAlgo(agraph,1);
        Set<Edge> bobMST=primAlgo(agraph,2);
        if(aliceMST.isEmpty() || bobMST.isEmpty())
            return -1;

        aliceMST.addAll(bobMST);
        return edges.length - aliceMST.size();
    }
}
