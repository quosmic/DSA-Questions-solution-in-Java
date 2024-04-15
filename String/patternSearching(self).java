import java.util.*;

public class Solution {
    public static List< Integer > search(String s, String pattern){
        // Write your code here.
         int m= s.length();
        int n= pattern.length();
        List<Integer> ans= new ArrayList<>();
        if(n>m){
        return ans;
    }
    List<Integer> ans1= search(s.substring(1),pattern);
    if(s.startsWith(pattern)){
        ans.add(1);
    }
    for(int num:ans1){
        ans.add(num+1);
    }
    return ans;
    }
}