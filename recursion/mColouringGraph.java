class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean isColourable(boolean graph[][], int idx, int colour[], int col){
    for(int i=0; i<graph.length;i++){
        if(graph[idx][i]==true && colour[i]== col){
            return false;
        }
    }    
     return true;
    }
    public boolean graphColour(boolean graph[][], int m, int idx, int colour[]){
        
        if(idx==graph.length){
          return true;
        }
            for(int i=1;i<=m;i++){
                if(isColourable(graph, idx, colour, i)){
                    colour[idx]=i; 
                     if (graphColour(graph, m, idx + 1, colour)){
                return true;
                     }
             else{   
            colour[idx]=-1;
             }               
             }
            }
        
    return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] colour = new int[n];
        return graphColour(graph,m,0,colour);
    }
}