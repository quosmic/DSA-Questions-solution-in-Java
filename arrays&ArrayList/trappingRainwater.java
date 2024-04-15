class Solution {
    public int[] prev(int[] nums){
        int n= nums.length;
        int[] prev= new int[n];
        prev[0]=nums[0];
        for(int i=1;i<n;i++){
            prev[i]= Math.max(nums[i],prev[i-1]);
        }
    return prev;
    }
    public int[] nxt(int[] nums){
     int n= nums.length;
     int[] nxt= new int[n];
     nxt[n-1]= nums[n-1];
     for(int i= n-2;i>=0;i--){
         nxt[i]= Math.max(nums[i],nxt[i+1]);
     }   
    return nxt;
    }
    public int trap(int[] height) {
        int sum=0;
        int[] pre= prev(height);
        int[] next= nxt(height);
        int n=height.length;
        if(n==0){
            return 0;
        }
        for(int i=0;i<n;i++){
            sum+=(Math.min(pre[i],next[i])-height[i]);
        }
    return sum;
    }
}