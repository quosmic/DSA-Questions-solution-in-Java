class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list= new ArrayList<>();
        if(nums.length==1){
        list.add(nums[0]);
        return list;
    }
    Arrays.sort(nums);
    int n= nums.length;
    int count=1;
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]==nums[i+1]){
            count++;
            
        }
        else{
            if(count>n/3){
                list.add(nums[i]);
            }
            count=1;
        }
    }    
    if(count>n/3){
                list.add(nums[n-1]);
            }
    return list;
    }
}