class Solution {
    public List<List<Integer>> twoSum(int[] nums, long target, int si){
        List<List<Integer>> ans = new ArrayList<>();
        
        int n= nums.length;
        int idx1=si;
        int idx2= n-1;
        while(idx1<idx2){
            if(idx2!=n-1&&nums[idx2]==nums[idx2+1]){
                idx2--;
                continue;
            }
            long sum=nums[idx1]+nums[idx2]; 
            if(sum==target){
                List<Integer> list1= new ArrayList<>();
                list1.add(nums[idx1]);
                list1.add(nums[idx2]);
                ans.add(list1);
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
    public List<List<Integer>> threeSum(int[] nums, long target, int si){
    int n= nums.length;
    List<List<Integer>> ans= new ArrayList<>();
    if(n<3){
        return ans;
    }
    for(int i=si;i<=n-3;i++){
        if(i!=si&&nums[i]==nums[i-1]){
            continue;
        }
        long targ= target-nums[i];
        List<List<Integer>> subresult= twoSum(nums,targ, i+1);
        for(List listing: subresult){
            listing.add(nums[i]);
            ans.add(listing);
        }
    }
    return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
    int n= nums.length;
    List<List<Integer>> ans= new ArrayList<>();
    if(n<4){
        return ans;
    }
    Arrays.sort(nums);
    for(int i=0;i<=n-4;i++){
        if(i!=0&&nums[i]==nums[i-1]){
            continue;
        }
        long targ= target-nums[i];
        List<List<Integer>> subresult= threeSum(nums,targ, i+1);
        for(List listing: subresult){
            listing.add(nums[i]);
            ans.add(listing);
        }
    }
    for(List listing: ans){
        Collections.sort(listing);
    }
    return ans;
    }
}