import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {

		// Write your code here
		ArrayList<Integer> ans= new ArrayList<>();
		Map<Integer, Integer> map= new HashMap<>();
		for(int i=0;i<k;i++){
			map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
		}
		ans.add(map.size());
		for(int i=k;i<arr.size();i++){
			if(map.get(arr.get(i-k))==1){
				map.remove(arr.get(i-k));
			}
			else{
				map.put(arr.get(i-k),map.get(arr.get(i-k))-1);
			}
		map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
		ans.add(map.size());
		}
	return ans;
	}
}
