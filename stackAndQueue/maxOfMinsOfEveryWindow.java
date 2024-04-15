import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] pse(int[] A) {
    int[] pse= new int[A.length];
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<A.length;i++){
            int num= A[i];
            while(!s.isEmpty()&&A[s.peek()]>=A[i]){
                s.pop();
            }
            if(s.isEmpty()){
                pse[i]= -1;
            }
            else{
                pse[i]= s.peek();
            }
            s.push(i);
        }
    return pse;
    }
    public static int[] nse(int[] A) {
    int[] nse= new int[A.length];
        Stack<Integer> s= new Stack<>();
        for(int i=A.length-1;i>=0;i--){
            int num= A[i];
            while(!s.isEmpty()&&A[s.peek()]>=A[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nse[i]= A.length;
            }
            else{
                nse[i]= s.peek();
            }
            s.push(i);
        }
    return nse;
    }
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] pse= pse(a);
        int[] nse= nse(a);
        int[] ans= new int[n];
        for(int i = 0;i<n;i++){
        ans[i] = Integer.MIN_VALUE;
    }
        for(int i=0;i<n;i++){
            int len= nse[i]-pse[i]-1;
            ans[len-1]= Math.max(ans[len-1],a[i]);
        }
        for(int i= n-2;i>=0;i--){
            ans[i]= Math.max(ans[i],ans[i+1]);
        }
    return ans;
    }
}

