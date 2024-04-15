class Solution {
    public class Pair implements Comparable<Pair>{
        int num;
        int freq;
        public Pair(int n, int f){
            this.num= n;
            this.freq= f;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.freq-this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
     HashMap<Integer,Integer> map= new HashMap<>();
     int n= nums.length;
     for(int i=0;i<n;i++){
         if(map.containsKey(nums[i])){
             map.put(nums[i],map.get(nums[i])+1);
         }
     else{
         map.put(nums[i],1);
     }
     }   
    PriorityQueue<Pair> pq= new PriorityQueue<>();
    for(Map.Entry<Integer,Integer>entry: map.entrySet()){
        int key= entry.getKey();
        int freq= entry.getValue();
        pq.add(new Pair(key,freq));
    }
    int[] ans= new int[k];
    for(int i=0;i<k;i++){
        ans[i]= pq.remove().num;
    }
    return ans;
    }
}