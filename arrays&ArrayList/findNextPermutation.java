class Solution {
    
    public void nextPermutation(int[] nums) {
        int n= nums.length;
        int idx1=-1;
        int idx2=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx1=i;
                break;
            }
        }
        if(idx1<0){
            Arrays.sort(nums);
            return;
        }
        for(int i=nums.length-1;i>idx1;i--){
            if(nums[i]>nums[idx1]){
                idx2= i;
                break;
            }
        }
   
    int temp= nums[idx1];
    nums[idx1]= nums[idx2];
    nums[idx2]=  temp;
    Arrays.sort(nums,idx1+1,n);//starting indexx included and ending index is not included
    }
}