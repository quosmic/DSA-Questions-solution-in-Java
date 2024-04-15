class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
    boolean vis[] = new boolean[V];
    vis[0]= true;
    ArrayList<Integer> list = new ArrayList<>();
    dfs(adj, vis, 0, list);
        return list;
    }
public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int curr, ArrayList<Integer> list){
    vis[curr]= true;
    list.add(curr);
    for(int i =0; i<adj.get(curr).size();i++){
        if(!vis[adj.get(curr).get(i)]){
           int num =  adj.get(curr).get(i);
           dfs(adj, vis, num,list);
        }
    }
}
    
}