class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer,Integer> map= new HashMap<>();
    int[] ans= new int[2];
      int n= nums.length;
      for(int i=0;i<n;i++){
          if(!map.containsKey(nums[i])){
          map.put(nums[i],i);
          }
       else if(nums[i]*2==target){
           ans[0]= map.get(nums[i]);
           ans[1]= i; 
        }
      }  
    if(ans[0]!=ans[1]){
        return ans;
    }
    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        int num1= entry.getKey();
        if(map.containsKey(target-num1)){
            ans[0]= entry.getValue();
            ans[1]= map.get(target-num1);
            break;
        }
    }
    return ans;
    }
}