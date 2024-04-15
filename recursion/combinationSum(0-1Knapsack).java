class Solution {
    public void combine(int[] candidates, int target, int idx, List<Integer> list, Set<List<Integer>> list1, int sum){

       if (idx == candidates.length) {
        if (target==0) {
            list1.add(new ArrayList<>(list));
        }
        return;
    }
    if(target==0){
            list1.add(new ArrayList<>(list));
            return;
    }

        if(candidates[idx]<=target){
        list.add(candidates[idx]);
        combine(candidates,target-candidates[idx],idx+1,list,list1,sum+candidates[idx]);
        idx++;
        list.remove(list.size()-1);
         while(idx<candidates.length && candidates[idx]==candidates[idx-1]){
             idx++;
         }
        combine(candidates,target,idx,list,list1,sum);
}
else{
    return;
}
    }
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      List<Integer> list = new ArrayList<>();
    Set<List<Integer>> list1 = new HashSet<>();
    combine(candidates,target,0,list,list1,0);
    List<List<Integer>> listing = new ArrayList<>();
    for(List<Integer> lister: list1){
        listing.add(lister);
    }
    return listing;    
}
}