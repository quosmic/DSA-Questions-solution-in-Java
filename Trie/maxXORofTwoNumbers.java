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
            int bit=(num>>i)&1;
            if(curr.children[bit]==null){
                curr.children[bit]= new TrieNode();
            }               
                curr= curr.children[bit];
            } 
    }
    public int findXOR(int num){
        TrieNode curr= root;
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(curr.children[1-bit]!=null){
                ans+=(1<<i);
                curr= curr.children[1-bit];
            }
            else{
                curr=curr.children[bit];
            }
        }
    return ans;
    }
    public int findMaximumXOR(int[] nums) {
    int ans=0;
    for(int i=0;i<nums.length;i++){
        insert(nums[i]);
    }    
    for(int i= 0;i<nums.length;i++){
        ans= Math.max(ans,findXOR(nums[i]));
    }
    return ans;
    }
}