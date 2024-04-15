class Solution {
    public int longestConsecutive(int[] nums) {
     Arrays.sort(nums);
    int n= nums.length;
    int maxCount=Integer.MIN_VALUE;
    int count=1;
    if(n==0){
        return 0;
    }
    if(n==1){
        return count;
    }
    for(int i=1;i<n;i++){
        if(nums[i]-nums[i-1]==1){
            count++;
            maxCount= Math.max(maxCount,count);
        }
        else if(nums[i]-nums[i-1]==0){
            continue;
        }
        else{

            count=1;
        }
    }
    return maxCount!=Integer.MIN_VALUE?maxCount:count;
    }
}