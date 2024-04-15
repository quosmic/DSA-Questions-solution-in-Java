public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int si=Integer.MAX_VALUE;
        int ei= Integer.MIN_VALUE;
        for(int i=0;i<m;i++){

                si= Math.min(si,matrix[i][0]);
                ei= Math.max(ei,matrix[i][n-1]);
            
        }
        int num=(m*n)/2;
        int res=-1;
        while(si<=ei){
            int mid=si+((ei-si)/2);
            if(isValid(matrix,m,n,mid)){
                res=mid;
                ei=mid-1;
            }
            else{
                si=mid+1;
            }
        }
    
    return res;
    }
    public static boolean isValid(int[][] matrix, int m, int n, int num){
        int count=0;
        for(int i=0;i<m;i++){
            int ans=-1;
            int si=0;
            int ei=n-1;
            while(si<=ei){
                int mid= si+(ei-si)/2;
                if(matrix[i][mid]<=num){
                    ans=mid;
                    si=mid+1;
                }
                else{
                    ei=mid-1;
                }
            }
            count+=(ans+1);
        }
    return count>=(((n*m)+1)/2);
    }
}