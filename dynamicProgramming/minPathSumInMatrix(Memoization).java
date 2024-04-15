class Solution {
    public int minPath(int[][] grid, int dp[][], int i, int j, int n, int m){
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
    if(dp[i][j]!=0){
        return dp[i][j];
    }
    if(i>=n||j>=m){
        return Integer.MAX_VALUE;
    }
    
    int val=grid[i][j];
    int nom;
    if(i==n-1){
     nom = minPath(grid,dp,i,j+1,n,m);
    }
    else if(j==m-1){
        nom = minPath(grid,dp,i+1,j,n,m);
    }
    else{
    int num1 = minPath(grid,dp,i+1,j,n,m);
    int num2 = minPath(grid,dp,i,j+1,n,m);
    nom = Math.min(num1,num2);
    }
    return dp[i][j]=nom+val;
    }
    public int minPathSum(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      int dp[][]= new int[n][m];

    return minPath(grid,dp,0,0,n,m);
    }
}