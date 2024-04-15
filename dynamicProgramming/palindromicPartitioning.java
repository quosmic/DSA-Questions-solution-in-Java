class Solution{
    static boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    static int palindrom(String str, int i, int j, int dp[]){
        if (i > j) {
            return 0; // Base case: empty substring or a palindrome
        }
  
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
        if(isPalindrome(i,k,str)){
            ans = Math.min(ans, 1+ palindrom(str,k+1,j,dp));
        }
            
        }
        return dp[i]=ans;
    }
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        int dp[]= new int[n];
            for(int j=0;j<n;j++){
                dp[j]=-1;
        }
    
        return palindrom(str,0,n-1,dp)-1;// final value -1 -> this is because we dont have to find the number of 
        //palindrom strings but the palindrom partitions. aa|bbb|cc-> here palindrom =3 but partitions =2 
        
    }
}