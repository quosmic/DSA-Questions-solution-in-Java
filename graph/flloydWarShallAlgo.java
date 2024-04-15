class Solution
{
    final static int INF = 99999;
    public void shortest_distance(int[][] matrix)
    {
        int V = matrix.length;
        // Code here 
        for (int i = 0; i < V; i++){
        for (int j = 0; j < V; j++){
        if(matrix[i][j]==-1){
            matrix[i][j] = INF;
        }
        }
        }
        for (int k = 0; k < V; k++) {
        for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
       
        matrix[i][j]
        = Math.min(matrix[i][j],matrix[i][k] + matrix[k][j]);
        }
        }
        }
        for(int m=0;m<V;m++){
            for(int n =0;n<V;n++){
                if(matrix[m][n]==INF){
                    matrix[m][n]=-1;
                }
            }
        }
        
    }
            }