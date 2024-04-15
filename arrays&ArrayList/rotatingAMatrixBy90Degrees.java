class Solution {
    public void rotate(int[][] matrix) {
      int n=  matrix.length;
      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<i;j++){
              int temp= matrix[j][i];
              matrix[j][i]= matrix[i][j];
              matrix[i][j]= temp;
          }
      }  
    for(int i=0;i<n;i++){
        int lt= 0;
        int rt= n-1;
        while(lt<=rt){
            int temp=matrix[i][lt];
            matrix[i][lt]= matrix[i][rt];
            matrix[i][rt]= temp;
            lt++;
            rt--;
        }
    }
    }
}