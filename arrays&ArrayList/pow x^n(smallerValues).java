class Solution {
    public double myPow(double x, int n) {
     if(x==0){
         return 0;
     }   
    if(n==0){
        return 1;
    }
    if(n<0){
        n= Math.abs(n);
        x= Math.pow(x,-1);
    }
    double[] ans= new double[n+1];
     ans[1]= x;
     for(int i=2;i<n+1;i++){
         ans[i]= x*ans[i-1];
     }
    return ans[n];
    }
}