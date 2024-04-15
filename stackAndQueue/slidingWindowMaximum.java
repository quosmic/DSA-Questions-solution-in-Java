class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return nums;
        }
    Deque<Integer> dq= new ArrayDeque<>();
    int[] ans= new int[nums.length-k+1];
    int ri=1;
    for(int i=0;i<k;i++){
        while(!dq.isEmpty()&&nums[dq.getLast()]<nums[i]){
            dq.removeLast();
        }
    dq.addLast(i);
    }
    ans[0]= nums[dq.getFirst()];
    for(int i=k;i<nums.length;i++){
        if( dq.getFirst()<(i-k+1)){
            dq.removeFirst();
        }
        while(!dq.isEmpty()&&nums[dq.getLast()]<nums[i]){
            dq.removeLast();
        }
    dq.addLast(i);
    ans[ri]= nums[dq.getFirst()];
    ri++;
    }
    return ans;
    }
}