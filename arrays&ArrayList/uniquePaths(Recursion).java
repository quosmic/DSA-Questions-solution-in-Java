class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1&&n==1){
            return 1;
        }
        if(m<1||n<1){
            return 0;
        }
        int count=0;
        count+=uniquePaths(m-1,n);
        count+=uniquePaths(m,n-1);
        return count;
    }
}