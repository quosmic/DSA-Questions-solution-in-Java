class Solution {
  public List<List<Integer>> twoSum(int[] nums, long target, int si){
      int n= nums.length;
      List<List<Integer>> ans= new ArrayList<>();
      if(n<=1){
          return ans;
      }
      int idx1= si;
      int idx2= n-1;
      long sum=0;
      while(idx1<idx2){
          if(idx1!=si&&nums[idx1]==nums[idx1-1]){
              idx1++;
              continue;
          }
          sum=nums[idx1]+nums[idx2];
          if(sum==target){
          List<Integer> list= new ArrayList<>();                
              list.add(nums[idx1]);
              list.add(nums[idx2]);
              ans.add(list);
              idx1++;
              idx2--;
          }
      else if(sum<target){
          idx1++;
      }
      else{
          idx2--;
      }
      }
  return ans;
  }
  public List<List<Integer>> threeSum(int[] nums) {
  int n= nums.length;
  List<List<Integer>> ans= new ArrayList<>();
  if(n<3){
      return ans;
  }    
  Arrays.sort(nums);
  for(int i=0;i<n;i++){
      if(i!=0&&nums[i]==nums[i-1]){
          continue;
      }
  long targ= -nums[i];
  List<List<Integer>> list= twoSum(nums,targ,i+1);
  for(List<Integer> listing: list){
      listing.add(nums[i]);
      ans.add(listing);
  }
  }
  return ans;
  }
}