class Solution {
    public int findDuplicate(int[] nums) {
      int[] ans= new int[nums.length-1];
      for(int x:nums){
          if(ans[x-1]==1){
              return x;
          }
        else{
            ans[x-1]=1;
        }
      }  
    return -1;
    }
}