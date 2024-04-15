public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here			
        int n= denominations.length;
        long dp[][]= new long[n+1][value+1];
        for(int i=0;i<n+1;i++){
			dp[i][0]=1;
            }
    
		for(int i=0;i<value+1;i++){
			dp[0][i]=0;
            }
    
        for(int i=1;i<n+1;i++){
            for(int j=1;j<value+1;j++){
                if(denominations[i-1]<=j){
                    dp[i][j]= dp[i-1][j]+dp[i][j-denominations[i-1]];
                }
            else{
				dp[i][j]= dp[i-1][j];
			}
			}
        }
    return dp[n][value];
	}
	
}