public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
    if(n==0){
        return 1;
        }
    if(m==0){
        return 0;
    }
    int res=-1;
    int low=1;
    int high=m;
    while(low<=high){
        int mid= (low+high)/2;
        int num= (int)Math.pow(mid,n);
        if(num==m){
            res= mid;
            break;
        }
        else if(num<m){
            low= mid+1;
        }
        else{
            high= mid-1;
        }
    }
    return res;
    }
}
