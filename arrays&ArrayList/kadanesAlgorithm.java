class Solution {
    public int maxSubArray(int[] nums) {
    int mse= Integer.MIN_VALUE;
    int cse=0;
    for(int i=0;i<nums.length;i++){
        cse+=nums[i];
        mse= Math.max(mse,cse);
        if(cse<0){
            cse=0;
        }      
    }
    return mse;
    }
}