class Solution {
    public int maxProduct(int[] nums) {
     int msp =Integer.MIN_VALUE;
     int cp = 1;
     for(int i=0;i<nums.length;i++){
         cp = cp*nums[i];
        if(cp>msp){
            msp=cp;
        }
        if(cp==0){
            cp=1;
        }
     } 
     cp = 1;
       for(int i=nums.length-1;i>=0;i--){
         cp = cp*nums[i];
        if(cp>msp){
            msp=cp;
        }
        if(cp==0){
            cp=1;
        }
     }   
    return msp;
    }
}