class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int indeg[] = new int[V];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                indeg[adj.get(i).get(j)]++;
            }
        }
    Queue<Integer> q = new LinkedList<>();
    for(int i=0;i<V;i++){
        if(indeg[i]==0){
            q.add(i);
        }
    }
    int count=0;
    while(!q.isEmpty()){
        int curr = q.remove();
        count++;
        for(int i = 0;i<adj.get(curr).size();i++){
            int num2 = adj.get(curr).get(i);
                indeg[num2]--;
                if(indeg[num2]==0){
                    q.add(num2);
                }
            
        }
    }
if(count==V){
    return false;
}
    
    return true;    
    }
}