import java.util.* ;
import java.io.*; 
public class Solution {
    public static long conquer(long[] arr, int si, int mid, int ei, long[] temp){
        long count=0;
        int i=si;
        int k= si;
        int j=mid+1;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]= arr[i++];
            }
            else{
                temp[k++]= arr[j++];
                count+=mid-i+1;
            }
        }
         while(i<=mid){
             temp[k++]= arr[i++]; 
         }
         while(j<=ei){
            temp[k++]= arr[j++]; 
         }
    for(int n=si; n<=ei;n++){
        arr[n]= temp[n];
    }
    return count;
    }
    public static long merge(long arr[], int si, int ei, long[] temp){
        if(si>=ei){
            return 0;
        }
        long vcount=0;
        int mid =  (ei+si)/2;
        vcount+=merge(arr,si,mid,temp);
        vcount+=merge(arr,mid+1,ei,temp);
        vcount+=conquer(arr,si,mid,ei,temp);
    return vcount;
    }
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long[] temp= new long[n];
        return merge(arr,0,n-1,temp);

    }
}