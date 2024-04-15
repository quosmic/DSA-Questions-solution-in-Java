class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
   static int eggs(int n, int k, int dp[][]){
       if(n==1){
           return k;
       }
   else if(k==1||k==0){
       return k;
   }
       if(dp[n][k]!=-1){
           return dp[n][k];
       }
       int ans= Integer.MAX_VALUE;
       for(int i=1;i<=k;i++){
           int num1 = eggs(n-1,i-1,dp);
           int num2 = eggs(n,k-i,dp);
           int num = 1+Math.max(num1,num2);
           ans = Math.min(ans,num);
       }
    return dp[n][k]=ans;
       
   }
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int dp[][] = new int[n+1][k+1];
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<k+1;j++){
	            dp[i][j]=-1;
	        }
	    }
	return eggs(n,k,dp);
	    
	}
}