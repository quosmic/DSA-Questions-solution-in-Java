class Solution {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], List<List<Integer>> connections) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
            for (int i = 0; i < connections.size(); i++) {
                               List<Integer> list = connections.get(i);
                graph[list.get(0)].add(new Edge(list.get(0), list.get(1)));
                graph[list.get(1)].add(new Edge(list.get(1),list.get(0) ));
            }
        }


        public static List<List<Integer>> dfs(ArrayList< Edge>graph[],int curr, int par, boolean vis[], int dt[],int low[], int time, List<List<Integer>>list){
            vis[curr] = true;
            dt[curr] = low[curr] = ++time;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (e.dest == par)
                    continue;
                if (vis[e.dest]) {
                    low[curr] = Math.min(low[curr], dt[e.dest]);
                } else {
                    dfs(graph, e.dest, curr, vis, dt, low, time, list);
                    low[curr] = Math.min(low[curr], low[e.dest]);
                    if (dt[curr] < low[e.dest]) {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(curr);
                        list1.add(e.dest);
                        list.add(list1);
                    }
                }
            }
            return list;
        }

        public static List<List<Integer>> getBridge (ArrayList < Edge > graph[]){
            int dt[] = new int[graph.length];
            int low[] = new int[graph.length];
            int time = 0;
            boolean vis[] = new boolean[graph.length];
            List<List<Integer>> list2 = new ArrayList<>();
            List<List<Integer>> list = dfs(graph, 0, -1, vis, dt, low, time, list2);
            return list;
        }

        public List<List<Integer>> criticalConnections ( int n, List<List<Integer>>connections){
            ArrayList<Edge> graph[] = new ArrayList[n];
            createGraph(graph, connections);
            return getBridge(graph);
        }
    }
