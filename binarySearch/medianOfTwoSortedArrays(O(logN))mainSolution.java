class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int x= nums1.length;
    int y= nums2.length;
    if(x>y){
        return findMedianSortedArrays(nums2,nums1);
    }    
    int si=0;
    int ei= x;
    while(si<=ei){
        int partX= (si+ei)/2;
        int partY= ((x+y+1)/2)-partX;
        int maxLeftX= (partX==0)?Integer.MIN_VALUE:nums1[partX-1];
        int maxLeftY= (partY==0)?Integer.MIN_VALUE:nums2[partY-1];
        int minRightX= (partX==x)?Integer.MAX_VALUE:nums1[partX];
        int minRightY= (partY==y)?Integer.MAX_VALUE:nums2[partY];
        if(maxLeftX<=minRightY && maxLeftY<=minRightX){
            if((x+y)%2!=0){
                return Math.max(maxLeftX,maxLeftY);
            }
            else return (double)(Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
        }
        if(maxLeftX>minRightY){
            ei= partX-1;
        }
        else{
            si= partX+1;
        }
    }
    return -1;
    }
}