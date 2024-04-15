class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int dp[][]= new int[n+1][amount+1];
        for(int i=0;i<n+1;i++){
                    dp[i][0]=0;
        }
          for(int i=0;i<amount+1;i++){
                    dp[0][i]=100001;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j]= Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            else{
            dp[i][j]= dp[i-1][j];
            }
            }
        }
    if(dp[n][amount]==100001){
        return -1;
    } 
    else return dp[n][amount];
    }
}