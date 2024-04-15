class Solution {
    public void combine(int[] candidates, int target, int idx, List<Integer> list, List<List<Integer>> list1, int sum){
        
           if (idx == candidates.length) {
            if (target==0) {
                list1.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[idx]<=target){
            list.add(candidates[idx]);
            combine(candidates,target-candidates[idx],idx,list,list1,sum+candidates[idx]);
            list.remove(list.size()-1);
             combine(candidates,target,idx+1,list,list1,sum);
        }
        else{combine(candidates,target,idx+1,list,list1,sum);}
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> list1 = new ArrayList<>();
        combine(candidates,target,0,list,list1,0);
        return list1;
    }
}