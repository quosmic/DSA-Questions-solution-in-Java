public class Solution {
    public int books(ArrayList<Integer> A, int B) {
    int n= A.size();
    if(n<B){
        return -1;
    }
    int ei=0;
    int si= Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        ei+=A.get(i);
        si= Math.max(si, A.get(i));
    }
    //BST on number of pages to be selected.  
    int res=-1;
    while(si<=ei){
        int mid= si+ ((ei-si)/2);
        if(isValid(A,n,B,mid)){
            res= mid;
            ei= mid-1;
        }
        else{
            si=mid+1;
        }
    }
    return res;
    }
    boolean isValid(ArrayList<Integer> A, int n, int B, int max){
        int num=1;
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+A.get(i)>max){
                sum=A.get(i);
                num++;
            }
            else{
                sum+=A.get(i);
            }
        if(num>B){
            return false;
        }
        }
    return true;
    }
}
