public class Solution {
    public int[] prevSmaller(int[] A) {
    int[] pse= new int[A.length];
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<A.length;i++){
            int num= A[i];
            while(!s.isEmpty()&&A[s.peek()]>=A[i]){
                s.pop();
            }
            if(s.isEmpty()){
                pse[i]= -1;
            }
            else{
                pse[i]= A[s.peek()];
            }
            s.push(i);
        }
    return pse;
    }
}
