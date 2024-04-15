class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int maxi=0;
        int sum=0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                maxi= i+1;
            }
        else{
            if(map.containsKey(sum)){
                maxi=Math.max(maxi,i-map.get(sum));
            }
            else{
                        map.put(sum,i);
            }
        }
        }
    return maxi;
        
    }
}