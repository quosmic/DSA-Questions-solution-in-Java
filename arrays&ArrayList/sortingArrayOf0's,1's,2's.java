class Solution {
    public void sortColors(int[] nums) {
        int r=0;
        int w=0;
        int b=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                r++;
            }
            else if(nums[i]==1){
                w++;
            }
            else{
                b++;
            }
        }
        int i=0;
        for(;i<r;i++){
            nums[i]=0;
        }
        for(;i<r+w;i++){
            nums[i] =1;
        }
        for(;i<r+w+b;i++){
            nums[i]=2;
        }
    }
}