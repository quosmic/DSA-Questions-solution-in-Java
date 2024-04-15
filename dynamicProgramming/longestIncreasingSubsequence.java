class Solution {
    public int lcs(int num1[], int num2[]){
        int n = num1.length;
        int m= num2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<m+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
    for(int i =1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
            if(num1[i-1]==num2[j-1]){
                dp[i][j] = 1+dp[i-1][j-1];
            }
        else{
        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
        }
    }
    return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      for(int i=0;i<nums.length;i++){
          set.add(nums[i]);
      } 
    int n=set.size();
      int nums1[] = new int[n];
      int j=0;
    for(int i: set){
        nums1[j]=i;
        j++;
    }
    Arrays.sort(nums1);
    return lcs(nums,nums1);
    }
}