class Solution {
public int minPathSum(int[][] arr)
{
// Initializing the number of rows and columns.
int n = arr.length, m = arr[0].length;

    // DP table initialization.
    int dp[][] = new int[n][m];
    
    // Initializing the value for the bottom-right cell, 
    // which is the starting point for our bottom-up approach.
    dp[n-1][m-1] = arr[n-1][m-1];
    
    // Initializing sum with the value of the bottom-right cell.
    int sum = arr[n-1][m-1];
    
    // Filling the values for the last row.
    // For any cell in the last row, the path sum is 
    // its own value plus the path sum of the cell to its right.
    for(int i = m-2; i >= 0; i--) {
        sum += arr[n-1][i];
        dp[n-1][i] = sum;
    }
    
    // Resetting the sum for the last column.
    sum = arr[n-1][m-1];
    
    // Filling the values for the last column.
    // For any cell in the last column, the path sum is 
    // its own value plus the path sum of the cell below it.
    for(int i = n-2; i >= 0; i--) {
        sum += arr[i][m-1];
        dp[i][m-1] = sum;
    }
    
    // Filling the rest of the DP table.
    // For any other cell, the path sum is its own value 
    // plus the minimum of the path sums of the cell to its right and below it.
    for(int i = n-2; i >= 0; i--) {
        for(int j = m-2; j >= 0; j--) {
            dp[i][j] = arr[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
        }
    }
    
    // The value at dp[0][0] gives the minimum path sum from the top-left 
    // to the bottom-right of the grid.
    return dp[0][0];
}
}