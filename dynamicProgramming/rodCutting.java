public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
	 int a[]=new int[n];
	for(int i=0; i<n; i++)
{
        a[i]=i+1;
}
	int m= price.length;
	int dp[][] = new int[m+1][n+1];
	for(int i=0;i<m+1;i++){
		for(int j=0;j<n+1;j++){
			if(i==0||j==0){
				dp[i][j]=0;
			}
		}
	}
	for(int i=1;i<m+1;i++){
		for(int j=1;j<n+1;j++){
			if(a[i-1]<=j){
				dp[i][j]= Math.max(dp[i-1][j], price[i-1]+dp[i][j-a[i-1]]);
			}
		else{
			dp[i][j]= dp[i-1][j];
		}
		}
	}
	return dp[m][n];
	}
}