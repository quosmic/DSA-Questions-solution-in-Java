class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n= nums2.length;
        int[] ans = new int[m+n];
        int idx1=0;
        int idx2=0;
        int i=0;
        while(idx1<m&&idx2<n){
            if(nums1[idx1]<=nums2[idx2]){
                ans[i]= nums1[idx1];
                i++;
                idx1++;
            }
            else{
                ans[i]= nums2[idx2];
                i++;
                idx2++;
            }
        }
        while(idx1<m){
            ans[i]=nums1[idx1];
            i++;
            idx1++;
        }
        while(idx2<n){
            ans[i]= nums2[idx2];
            i++;
            idx2++;
        }
    int median= ans[(m+n)/2];
    if((n+m)%2!=0){
        return median;
    }
    int median2= ans[((m+n)/2)-1];
    return (double)(median+median2)/2;
    }
}