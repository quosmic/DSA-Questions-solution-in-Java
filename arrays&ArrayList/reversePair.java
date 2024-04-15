class Solution {
    public static int conquer(int[] arr, int si, int mid, int ei, int[] temp){
        int count=0;
        int idx=mid+1;
        for(int m=si;m<=mid;m++){
            while(idx<=ei && arr[m]>2L*arr[idx]){
                idx++;
            }
        count+=idx-(mid+1);
        }
   
        int i=si;
        int k= si;
        int j=mid+1;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]= arr[i++];
            }
            else{
                temp[k++]= arr[j++];
                }
            }
         while(i<=mid){
             temp[k++]= arr[i++]; 
         }
         while(j<=ei){
            temp[k++]= arr[j++]; 
         }
    for(int n=si; n<=ei;n++){
        arr[n]= temp[n];
    }
    return count;
    }
    public static int merge(int arr[], int si, int ei, int[] temp){
        if(si>=ei){
            return 0;
        }
        int vcount=0;
        int mid =  (ei+si)/2;
        vcount+=merge(arr,si,mid,temp);
        vcount+=merge(arr,mid+1,ei,temp);
        vcount+=conquer(arr,si,mid,ei,temp);
    return vcount;
    }
    public int reversePairs(int[] nums) {
    int n= nums.length;
    if(n==1||n==0){
        return 0;
    }
    int[] temp= new int[n];
    int ans= merge(nums,0,n-1,temp);  
    if(ans==-1){
        return 0;
    }     
    return ans;
    }
}