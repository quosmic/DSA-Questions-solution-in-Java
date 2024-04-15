import java.util.*;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
    int n= stalls.length;
    if(n<k){
        return -1;
    }
    Arrays.sort(stalls);
    int si=1;//min. number of partitions.
    int ei=stalls[n-1]-stalls[0];//max number of partitions
    
    int res=-1;
    while(si<=ei){
        int mid= si+ ((ei-si)/2);
        if(isValid(stalls,n,k,mid)){
            res= mid;
            si=mid+1;
        }
        else{
            ei= mid-1; 
        }
    }
    return res;
    }
    public static boolean isValid(int[] stalls, int n, int k, int max){
        int sum=stalls[0];
        int num=1;
        for(int i=0;i<n;i++){
            if(stalls[i]-sum>=max){
                sum=stalls[i];
                num++;
            }
            if(num>=k){
                return true;
            }
        }
        return false;
    }
}