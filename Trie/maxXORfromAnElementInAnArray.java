class Solution {
    public class TrieNode{
            TrieNode[] children= new TrieNode[2];
            TrieNode(){
                children[0]= null;
                children[1]= null;
            }
        }
        public TrieNode root= new TrieNode();
        public void insert(int num){
            TrieNode curr= root;
            for(int i=31;i>=0;i--){
                int bit= (num>>i)&1;
                if(curr.children[bit]==null){
                    curr.children[bit]= new TrieNode();
                }
                curr= curr.children[bit];
        }
    }
    public int findMaxXOR(int num){
        TrieNode curr= root;
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit= (num>>i)&1;
            if(curr==null){
                return -1;
            }
            if(curr.children[1-bit]!=null){
                ans+=(1<<i);
                curr=curr.children[1-bit];
            }
            else{
                curr= curr.children[bit];
            }
        }
    return ans;
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
    Arrays.sort(nums);
    int n= queries.length;
    int[][] q= new int[n][3];
    for(int i=0;i<n;i++){
        q[i][0]=i;
        q[i][1]= queries[i][0];
        q[i][2]= queries[i][1];
    }
    Arrays.sort(q,Comparator.comparingInt(o->o[2]));   
    int[] ans= new int[n];
    int idx1=0;
    
    for(int[] q1: q){

        while(idx1 < nums.length && nums[idx1]<=q1[2]){
            insert(nums[idx1]);
            idx1++;
        }
        ans[q1[0]]= findMaxXOR(q1[1]);
        
    }
    return ans;
    }
}
