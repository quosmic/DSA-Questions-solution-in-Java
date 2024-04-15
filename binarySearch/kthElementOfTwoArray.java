class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n>m){
            return kthElement(arr2,arr1,m,n,k);
        }
        if(n==0){
            return arr2[k-1];
        }
        if(k==1){
            return Math.min(arr1[0],arr2[0]);
        }
     
        int si=Math.max(0,k-m);// if m<k then we have to select a total elements k to left
        int ei=Math.min(n,k);//if n<k then we have to choose n
        while(si<=ei){
            int partX= (si+ei)/2;
            int partY= k-partX;// this is why we cant have ei= n at all times.
            int maxLeftX= (partX==0)?Integer.MIN_VALUE:arr1[partX-1];
            int maxLeftY= (partY==0)?Integer.MIN_VALUE:arr2[partY-1];
            int minRightX= (partX==n)?Integer.MAX_VALUE:arr1[partX];
            int minRightY= (partY==m)?Integer.MAX_VALUE:arr2[partY];
            if(maxLeftX<=minRightY&&maxLeftY<=minRightX){
                return Math.max(maxLeftX,maxLeftY);
            }
            if(maxLeftX>minRightY){
                ei=partX-1;
            }
            else{
                si= partX+1;
            }
        }
    return arr2[k-n-1];
        
    }

    
}