class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
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
    ArrayList<Integer> val = new ArrayList<>();
    int top[] = new int[V];
    while(!q.isEmpty()){
        int curr = q.remove();
        val.add(curr);
        for(int i = 0;i<adj.get(curr).size();i++){
            int num2 = adj.get(curr).get(i);
                indeg[num2]--;
                if(indeg[num2]==0){
                    q.add(num2);
                }
            
        }
    }
for(int i=0;i<V;i++){
    top[i]=val.get(i);
}
    return top;    
    }
}