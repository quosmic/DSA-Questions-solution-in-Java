public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
    int[] my= new int[A.length];
    int[] ans= new int[2];
    for(int x: A){
        if(my[x-1]==1){
            ans[0]=x;
        }
        else{
            my[x-1]=1;
        }
    }
    for(int i=0;i<my.length;i++){
        if(my[i]==0){
            ans[1]= i+1;
        }
    }
    return ans;
    }
}
