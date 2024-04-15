class Solution{
	static int mcm(int i, int arr[], int dp[][], int j){
		if(i==j){
			return 0;
		}
	if(dp[i][j]!=-1){
		return dp[i][j];
	}
	int ans= Integer.MAX_VALUE;
	for(int k=i;k<=j-1;k++){
		int cost1 = mcm(i,arr, dp, k);
		int cost2 = mcm(k+1,arr,dp,j);
		int cost3 = arr[i-1]*arr[k]*arr[j];
		ans = Math.min(ans,cost1+cost2+cost3);
	}
		return dp[i][j]= ans;
	}
   static int matrixMultiplication(int N, int arr[])
   {
	   // code here
	   int dp[][] = new int[N][N];
	   for(int i=0;i<N;i++){
	   Arrays.fill(dp[i],-1);
	   }
	   return mcm(1,arr,dp,N-1);
   }
}