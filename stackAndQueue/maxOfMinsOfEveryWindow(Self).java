import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] minSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return nums;
        }
    Deque<Integer> dq= new ArrayDeque<>();
    int[] ans= new int[nums.length-k+1];
    int ri=1;
    for(int i=0;i<k;i++){
        while(!dq.isEmpty()&&nums[dq.getLast()]>nums[i]){
            dq.removeLast();
        }
    dq.addLast(i);
    ans[0]= nums[dq.getFirst()];
    }
    for(int i=k;i<nums.length;i++){
        while(!dq.isEmpty()&& dq.getFirst()<(i-k+1)){
            dq.removeFirst();
        }
        while(!dq.isEmpty()&&nums[dq.getLast()]>nums[i]){
            dq.removeLast();
        }
    dq.addLast(i);
    ans[ri]= nums[dq.getFirst()];

    ri++;
    }
    return ans;
    }
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] ans= new int[n];
        int maxi= -1;
        for(int i=1;i<=n;i++){
            int[] ans1= minSlidingWindow(a,i);
             maxi= Integer.MIN_VALUE;
            for(int num:ans1){
                maxi= Math.max(maxi, num);
            }
            ans[i-1]= maxi;
        }
    return ans;
    }
    
}

