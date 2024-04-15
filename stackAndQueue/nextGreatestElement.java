import java.util.*;
public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        // Write your code here.
        int[] nge= new int[n];
        Stack<Integer> s= new Stack<>();
        for(int i=n-1;i>=0;i--){
            int num= arr[i];
            while(!s.isEmpty()&&arr[s.peek()]<=arr[i]){
                s.pop();
            }
        if(s.isEmpty()){
            nge[i]=-1;
        }
        else{
            nge[i]=arr[s.peek()];
        }
        s.push(i);
        }
    return nge;
    }
}