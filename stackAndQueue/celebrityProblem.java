import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
		Deque<Integer> dq= new ArrayDeque<>();
		for(int i=0;i<n;i++){
			while(!dq.isEmpty()&&Runner.knows(dq.getLast(),i)){
				dq.removeLast();
			}
			
			dq.addLast(i);
		}
    if(dq.isEmpty()){
		return -1;
	}
	int potentialCelebrity = dq.getFirst();

        // Validate if the potential celebrity knows no one and everyone knows them
        for (int i = 0; i < n; i++) {
            if (i != potentialCelebrity && (Runner.knows(potentialCelebrity, i)||!Runner.knows(i, potentialCelebrity))) {
                return -1; // Not a valid celebrity
            }
        }

        return potentialCelebrity;
	}
}