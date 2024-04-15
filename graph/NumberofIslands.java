class Solution {
    public int numIslands(char[][] grid) {
    int n= grid.length;
    int m = grid[0].length;
    int count = 0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m;j++){
            if(grid[i][j]=='1'){
                transformation(grid,i,j,n,m);
                count++;
            }
        }
    }
    return count;
    }
public void transformation(char[][] grid, int row, int col,int n, int m) {
   if (row < 0 || row >= n || col < 0 || col >= m || 
   grid[row][col] == '0') {
            return;
        }
grid[row][col] = '0';
transformation(grid,row+1,col,n,m);
transformation(grid,row-1,col,n,m);
transformation(grid,row,col+1,n,m);
transformation(grid,row,col-1,n,m);

}
}
