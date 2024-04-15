class Solution {
    public double myPow(double x, int m) {
     if(x==0){
         return 0;
     }   
    if(m==0){
        return 1;
    }
    long n=Math.abs((long)m);
    
    double ans = getPow(x,n);
    if(m<0){
        ans= 1/ans;
    }
    return ans;
    }
    public double getPow(double x, long n){
        if(n==0){
            return 1;
        }
        if(n%2==1){
            return x*getPow(x,n-1);
        }
        return getPow(x*x,n/2);
    }
}