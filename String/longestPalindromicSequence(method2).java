class Solution {
    public String longestPalindrome(String s) {
    int st=0;
    int end=0;
    int n=s.length();
    boolean[][] dp= new boolean[n][n];    
    for(int j=0;j<n;j++){
        for(int i=0;i<=j;i++){
            int len= j-i+1;
            if(len==1){
                dp[i][j]= true;
            }
            else if(len==2){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]= true;
                }
                else{
                    dp[i][j]=false;
                }
            }
        else{
            if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                dp[i][j]=true;
            }
        }
        if(dp[i][j]&&len>end-st+1){
            end=j;
            st=i;
        }
        }
    }
    return s.substring(st,end+1);
    }
}