class Solution
{
    //Function to find number of strongly connected components in the graph.
    public static void topSortUtil(ArrayList<ArrayList<Integer>> adj, boolean vis[], int curr,
    Stack<Integer> s){
        vis[curr]= true;
        for(int i=0;i<adj.get(curr).size();i++){
           int num = adj.get(curr).get(i);
           if(!vis[num]){
               topSortUtil(adj,vis,num,s);
           }
        }
    s.push(curr);
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int curr){
    vis[curr]= true;
    for(int i =0; i<adj.get(curr).size();i++){
        if(!vis[adj.get(curr).get(i)]){
           int num =  adj.get(curr).get(i);
           dfs(adj, vis, num);
        }
    }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
    boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
        if(!vis[i]){
            topSortUtil(adj,vis,i,s);
        }
    }
    ArrayList<ArrayList<Integer>> alpha = new ArrayList<>();
    for(int i=0;i<V;i++){
        alpha.add(i,new ArrayList<Integer>());
    }
    for(int i=0; i<V;i++){// swapping node
        for(int j=0;j<adj.get(i).size();j++){
        int node = adj.get(i).get(j);
            alpha.get(node).add(i);
        }    
    }
    Arrays.fill(vis,false);
    int count=0;
        while(!s.isEmpty()){
        int num = s.pop();
        if(!vis[num]){
            dfs(alpha,vis,num);
            count++;
        }
}
    return count;
    }
}
