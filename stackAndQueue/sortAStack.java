import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
	if(stack.isEmpty()){
		return;
	}
	int num= stack.pop();
	
	sortStack(stack);
	insertCorrectly(stack,num);
	
	}
	public static void insertCorrectly(Stack<Integer> stack, int num){
		if(stack.isEmpty()||stack.peek()<num){
			stack.push(num);
			return;
		}
		int top= stack.pop();
		insertCorrectly(stack,num);
		stack.push(top);
	}
}