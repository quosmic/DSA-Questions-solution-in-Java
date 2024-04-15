import java.util.ArrayList;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
	int dp[][]= new int[n+1][w+1];
	for(int i=0;i<n+1;i++){
		dp[i][0]=0;
	}
	for(int i=0;i<w+1;i++){
		dp[0][i]=0;
	}
	for(int i=1;i<n+1;i++){
		for(int j=1;j<w+1;j++){
			if(weights.get(i-1)<=j){
				dp[i][j]= Math.max(dp[i-1][j],values.get(i-1)+dp[i-1][j-weights.get(i-1)]);
			}
		else{
			dp[i][j]=dp[i-1][j];
		}
		}
	}
	return dp[n][w];
	}
}