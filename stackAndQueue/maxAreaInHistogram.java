class Solution {
     public int[] pse(int[] A) {
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
                pse[i]= s.peek();
            }
            s.push(i);
        }
    return pse;
    }
    public int[] nse(int[] A) {
    int[] nse= new int[A.length];
        Stack<Integer> s= new Stack<>();
        for(int i=A.length-1;i>=0;i--){
            int num= A[i];
            while(!s.isEmpty()&&A[s.peek()]>=A[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nse[i]= A.length;
            }
            else{
                nse[i]= s.peek();
            }
            s.push(i);
        }
    return nse;
    }
    public int largestRectangleArea(int[] heights) {
     int[] pse= pse(heights);
     int[] nse= nse(heights);
     int maxVal= 0;
   
     for(int i=0;i<heights.length;i++){
         int ht= heights[i];
         int wd= nse[i]-pse[i]-1;
         
         maxVal= Math.max(maxVal,ht*wd);
     }   
    return maxVal;
    }
}