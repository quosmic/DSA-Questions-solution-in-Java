class Solution {
    public void subsW(int[] nums, List<Integer> list1, int idx, Set<List<Integer>> list){
        if(idx==nums.length){
            list.add(new ArrayList<>(list1));
            return;        
        }
        list1.add(nums[idx]);
        subsW(nums, list1,idx+1,list);
        list1.remove(list1.size()-1);
        subsW(nums, list1, idx+1, list);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        subsW(nums,list1,0,list);
        List<List<Integer>> listing = new ArrayList<>();
        for(List<Integer>lister:list){
            listing.add(lister);
        }
        return listing;
    }
}