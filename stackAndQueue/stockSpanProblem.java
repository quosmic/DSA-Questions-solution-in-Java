import java.util.*;
public class Solution {
    public static int[] findStockSpans(int []prices) {
        // Write your code here.
        if(prices.length==0){
            return prices;
        }
        Stack<Integer> s= new Stack<>();
        int maxi=0;
        int[] ans= new int[prices.length];
        int n= prices.length;
        s.add(0);
        ans[0]=1;
        for(int i=1;i<n;i++){
            while(!s.isEmpty()&& prices[i]>prices[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]= i+1;
            }
            else{
                ans[i]= i-s.peek();
            }
        s.push(i);
        }
    return ans;
    }
}