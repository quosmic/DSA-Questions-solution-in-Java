class Solution {
    public class Pair{
        int row;
        int col;
        Pair(int r, int c){
            this.row=r;
            this.col=c;
        }
    }
    public void setZeroes(int[][] matrix) {
    int m= matrix.length;
    int n= matrix[0].length;
    List<Pair> list= new ArrayList<>();
 
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==0){
                list.add(new Pair(i,j));
            }
        }
    }
    for(Pair p: list){
        for(int i=0;i<n;i++){
            matrix[p.row][i]=0;
        }
        for(int i=0;i<m;i++){
            matrix[i][p.col]=0;
        }
    }
    }
}