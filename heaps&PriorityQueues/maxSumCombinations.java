public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
     PriorityQueue<Integer> pq= new PriorityQueue<>();
    Collections.sort(A,Comparator.reverseOrder());
        Collections.sort(B,Comparator.reverseOrder());
    
    int n= A.size();
    for(int i=0;i<C;i++){
        for(int j=0;j<C;j++){
             int sum= A.get(i)+B.get(j);
            if(pq.size()<C){
                 pq.add(sum);
            }
           
            else if(sum>pq.peek()){
                pq.remove();
                pq.add(sum);
            }
        else{
            break;
        }
        }
    }
    ArrayList<Integer> ans= new ArrayList<>();
    for(int i=C-1;i>=0;i--){
        ans.add(0,pq.peek());
        pq.remove();
    }
    return ans;
    }
}
