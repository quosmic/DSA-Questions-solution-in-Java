class Solution {
    public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    
    permute(nums,list,0);
    return list;   
    }

 public void permute(int nums[], List<List<Integer>> list, int idx){
        if(nums.length==idx){
            List<Integer> temp= new ArrayList<>();
            for(int a: nums){
                temp.add(a);
            }
        list.add(new ArrayList<>(temp));
        }
        for(int i=idx;i<nums.length;i++){  
            int curr = nums[idx];
            nums[idx]= nums[i];
            nums[i]= curr;
            permute(nums, list,idx+1);
            curr= nums[idx];
            nums[idx]= nums[i];
            nums[i]= curr;
        }
    }
   
}