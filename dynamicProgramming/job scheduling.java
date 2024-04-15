import java.util.*;
public class Solution {
    public static int[] jobScheduling(int [][]jobs) {
        // Write your code here
     // Write your code here
        Arrays.sort(jobs,(a,b)->(b[2]-a[2]));// sorting in dec order on the basis of Profit
        int n = jobs.length;
        int count = 0;
        int profit = 0;
        int deadline = 0;
        for(int i=0;i<jobs.length;i++){
            if(jobs[i][1]>deadline){
                deadline=jobs[i][1];
            }
        }
        boolean vis[] = new boolean[deadline+1];
        for(int i=0;i<jobs.length;i++){
            for(int j=jobs[i][1];j>0;j--){
            if(!vis[j]){
                vis[j]= true;
                profit = profit + jobs[i][2];
                count++;
                break;
            }
        }
        } 
    int ans[] = {count, profit};
    return ans;
    }
}
