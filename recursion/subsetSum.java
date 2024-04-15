class Solution{
    void subSums(ArrayList<Integer> arr, int N, int idx, ArrayList<Integer> list, int sum){
        if(idx==N){
            list.add(sum);
            return;
        }
        subSums(arr,N,idx+1,list,sum+arr.get(idx));
        subSums(arr,N,idx+1,list,sum);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        subSums(arr, N , 0, list, 0);
        return list;
        
    }
}