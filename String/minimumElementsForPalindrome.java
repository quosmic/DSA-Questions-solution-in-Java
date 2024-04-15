public class Solution {
    public int solve(String A) {
    StringBuilder sb= new StringBuilder(A);
    sb.reverse();
    String ans= A+'&'+sb.toString();
    int n= ans.length();
    int[] lps= new int[ans.length()];
    int i=0;
    int j=1;
    while(j<n){
        if(ans.charAt(i)==ans.charAt(j)){
            lps[j]=i+1;
            i++;
            j++;
        }
        else{
            if(i==0){
                lps[j]=0;
                j++;
            }
            else{
                i= lps[i-1];
            }
        }
    }
    return A.length()-lps[n-1];
    }
}
