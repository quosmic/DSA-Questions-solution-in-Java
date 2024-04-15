class Solution {
    public int knapSack(int nums[], int sum){
        int n=nums.length;
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
    for(int i=1;i<n+1;i++){
        for(int j=1;j<sum+1;j++){
            if(nums[i-1]<=j){
                dp[i][j]= Math.max(dp[i-1][j], nums[i-1]+dp[i-1][j-nums[i-1]]);
            }
        else{
            dp[i][j]= dp[i-1][j];
        }
        }
    }
    return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
       int sum=0;
       for(int i=0;i<nums.length;i++){
           sum+=nums[i];
       } 
    int num = knapSack(nums,sum/2);
    if(num*2==sum){
        return true;
    }
    else return false;
    }
}