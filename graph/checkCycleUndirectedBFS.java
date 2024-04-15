class Solution {
    // Function to detect cycle in an undirected graph.
    public class Node{
        int n;
        int par;
        Node(int n, int p){
            this.n=n;
            this.par=p;
        }
    }
    public boolean isCycleUtil(int V, ArrayList<ArrayList<Integer>> adj, boolean vis[], int nev){
    Queue<Node>q=new LinkedList<>();
        vis[nev]=true;
        q.add(new Node(nev,-1));
        while(!q.isEmpty()){
            Node curr = q.remove();
            vis[curr.n]=true;
            for(int i=0;i<adj.get(curr.n).size();i++){
                if(!vis[adj.get(curr.n).get(i)]){
                    vis[adj.get(curr.n).get(i)]=true;
                    q.add(new Node(adj.get(curr.n).get(i),curr.n));
                }
                else if(adj.get(curr.n).get(i)!=curr.par){
                    return true;
                }
            }
        }
        return false;
    }    
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
     boolean vis[]=new boolean[V];
    for(int i=0;i<V;i++){
        if(!vis[i]){
            if(isCycleUtil(V,adj,vis,i)){
                return true;
            }
        }
    }
return false;
    }   
    }