class Solution {
    public int removeDuplicates(int[] nums) {
     int count=1;
     int n= nums.length;
     List<Integer> list= new ArrayList<>();
     if(n==0){
         return 0;
     }
     list.add(nums[0]);
     for(int i=1;i<n;i++){
         if(nums[i]==nums[i-1]){
             continue;
             }
    else{
        list.add(nums[i]);
        count++;
    }
     }   
    int m= list.size();
    for(int i=0;i<m;i++){
        nums[i]= list.get(i);
    }
    return count;
    }
}