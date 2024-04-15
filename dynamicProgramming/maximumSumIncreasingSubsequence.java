class Solution
{
	public int lcs(int arr[],int n,int num[],int m){
	    int dp[][]=new int[n+1][m+1];
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<m+1;j++){
	            if(i==0||j==0){
	                dp[i][j]=0;
	            }
	        }
	    }
	for(int i=1;i<n+1;i++){
	    for(int j=1;j<m+1;j++){
	        if(arr[i-1]==num[j-1]){
	            dp[i][j]=arr[i-1]+dp[i-1][j-1];
	        }
	    else{
	        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
	    }
	        
	    }
	}
	    return dp[n][m];
	}
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    HashSet<Integer> set= new HashSet<>();
	    for(int i=0;i<n;i++){
	        set.add(arr[i]);
	    }
	int m = set.size();
	int num[] = new int[m];
	int k=0;
	for(int number: set){
	    num[k]= number;
	    k++;
	}
	Arrays.sort(num);
	return lcs(arr,n,num,m);    
	}  
}