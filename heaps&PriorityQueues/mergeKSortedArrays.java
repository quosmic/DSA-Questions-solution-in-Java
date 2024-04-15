import java.util.* ;
import java.io.*; 

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		ArrayList<Integer> ans= new ArrayList<>();
		for(int i=0;i<k;i++){
			for(int j=0;j<kArrays.get(i).size();j++){
				pq.add(kArrays.get(i).get(j));
			}
		}
	while(!pq.isEmpty()){
		ans.add(pq.remove());
	}
	return ans;
	}
}
