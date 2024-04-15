class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        int[][] ans1= new int[2*n][2];
        for(int i=0;i<n;i++){
            ans1[i][0]= arr[i];
            ans1[i][1]= 0;
        }
        for(int i=n;i<2*n;i++){
            ans1[i][0]= dep[i-n];
            ans1[i][1]=1;
        }
    Arrays.sort(ans1,Comparator.comparingDouble(o->o[0]));
    int m= ans1.length;
    int maxi=0;
    int ansMax=0;
    for(int i=0;i<m;i++){
        if(ans1[i][1]==0){
            maxi++;
            ansMax= Math.max(ansMax,maxi);
        }
    else{
        maxi--;   
    }
    }
        return ansMax;
    }
    
}
