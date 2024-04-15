class Solution {
    public int majorityElement(int[] nums) {
    if(nums.length==1){
        return nums[0];
    }
    Arrays.sort(nums);
    int idx=-1;
    int count=1;
    int maxCount= -1;
    for(int i=1;i<nums.length;i++){
        if(nums[i]==nums[i-1]){
            count++;
            if(maxCount<count){
                idx=i;
                maxCount=count;
            }
        }
        else{
            count=1;
        }
    }    
    return nums[idx];
    }
}