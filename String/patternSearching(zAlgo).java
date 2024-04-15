import java.util.*;

public class Solution {
    public static List< Integer > search(String s, String pattern){
        // Write your code here.
    int n= s.length();
    int m= pattern.length();
    List<Integer> ans= new ArrayList<>();
    List<Integer> zval= new ArrayList<>();
    String tot= pattern+'$'+s;
    int i=0;
    int j=1;
    while(j<tot.length()){
        int k=i;
        int p=j;
        int count=0;
        while(p<tot.length()){
            if(tot.charAt(k)==tot.charAt(p)){
            count++;
            k++;
            p++;
        }
        else break;
        }
        zval.add(count);
        if(count==m){
            ans.add(j-m);
        }
        j++;
    }    
    return ans;
    }
}