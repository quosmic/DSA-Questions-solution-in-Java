class Solution {
    static class Edge {
  int src;
  int dest;
  int wt;
  public Edge(int s, int d, int w) {
  this.src = s;
  this.dest = d;
  this.wt = w;
  }
  }
                          static class Pair {
                          int n;
                          int path;
                          int stops;
                          public Pair(int n, int path, int stops) {
                          this.n = n;
                          this.path = path;
                          this.stops = stops;
                          }
                          }
  
  
      public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      ArrayList<Edge> graph[] = new ArrayList[n];
          for(int i=0; i<graph.length; i++) {
          graph[i] = new ArrayList<>();
      }
          for(int i=0;i<flights.length;i++){
              Edge e = new Edge(flights[i][0],flights[i][1],flights[i][2]);
              graph[flights[i][0]].add(e);
          }
      int cost = dijkstraWork(graph,src,dst,k);
   
  return cost;
      }
  
  public static int dijkstraWork(ArrayList<Edge> graph[], int src, int dest, int k) {
  Queue<Pair> pq = new LinkedList<>();
  int dist[] = new int[graph.length];
  Arrays.fill(dist, Integer.MAX_VALUE);
   dist[src] = 0;
  pq.add(new Pair(src, 0,0));
  while(!pq.isEmpty()) {
  Pair curr = pq.remove();
  if(curr.stops>k){
   break;
  }
  for(int i=0; i<graph[curr.n].size(); i++) {
  int num = curr.stops;
  Edge e = graph[curr.n].get(i);
  int u = e.src;
  int v = e.dest;
  if ( num <= k && curr.path + e.wt < dist[v]) {
      dist[v] = curr.path + e.wt;
      pq.add(new Pair(v, dist[v], num+1));
  }
  }
  }
     if (dist[dest] == Integer.MAX_VALUE) {
              return -1;
          } else {
              return dist[dest];
          }
  }
  }