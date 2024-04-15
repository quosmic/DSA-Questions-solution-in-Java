import java.util.* ;
import java.io.*; 

public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        ArrayList<Integer> list= new ArrayList<>();
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(q[i][0]==0){
                pq.add(q[i][1]);
            }
            else if(!pq.isEmpty()){
                list.add(pq.remove());
            }
        }
        int[] ans= new int[list.size()];
        int m= ans.length;
        for(int i=0;i<m;i++){
            ans[i]= list.get(i);
        }
    return ans;
    }
}