class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1){
            return nums;
        }
        Queue<Integer> q= new LinkedList<>();
        ArrayList<Integer> list= new ArrayList<>();

        int maxi= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
            if (i >= k - 1) {
                maxi = Math.max(maxi, nums[i]);

                if (i-k>=0&&nums[i - k ] == maxi) {
                    
                    maxi = maxCal(q);            
                int num=q.remove(); 
                }
                else{
                    q.remove();
                }
                list.add(maxi);
            }
            else{
                maxi= Math.max(maxi,nums[i]);
            }
        }
        int answer[]= new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]= list.get(i);
        }
        return answer;
}
public int maxCal(Queue<Integer> q){
    int max = Integer.MIN_VALUE;
        for (int num : q) {
            max = Math.max(max, num);
        }
        return max;

}
}