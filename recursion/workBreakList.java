import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static void breaking(String s, ArrayList<String> dictionary, String s1, String s2, ArrayList<String> list){
			if(s.length()==0){
				list.add(s1);
				return;
			}
		for(int i=0;i<s.length();i++){
			String prefix = s.substring(0, i+1);

			if(dictionary.contains(s.substring(0, i+1))){ 
				breaking(s.substring(i+1),dictionary, s1+prefix+s2, s2, list);
			}
		}
	}
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
		ArrayList<String> list = new ArrayList<>();
		String s1 ="";
		String s2 = " ";
		breaking(s,dictionary,s1,s2,list);
		return list;
	
	}
}