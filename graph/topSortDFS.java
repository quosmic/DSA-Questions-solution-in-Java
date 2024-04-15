class Solution
{
    //Function to return list containing vertices in Topological order. 
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
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        int top[] = new int[V];
        for(int i=0;i<V;i++){
        if(!vis[i]){
            topSortUtil(adj,vis,i,s);
        }
    }
    for(int i=0;i<V;i++){
        top[i]=s.pop();
    }
    return top;    
    }
}