class Solution {
    public int[] lps(String s){
        int n= s.length();
        int[] ls= new int[n];
        int i1=0;
        int i2=1;
        while(i2<n){
            if(s.charAt(i1)==s.charAt(i2)){
                ls[i2]= i1+1;
                i1++;
                i2++;
            }
            else{
                if(i1==0){
                    ls[i2]=0;
                    i2++;
                }
                else{
                i1= ls[i1-1];
                }
            }
        }
    return ls;
    }
    public int strStr(String haystack, String needle) {
        int[] ls= lps(needle);
        int m= haystack.length();
        int n= needle.length();
        int i1=0;
        int i2=0;
        while(i1<m&&i2<n){
            if(haystack.charAt(i1)==needle.charAt(i2)){
                i1++;
                i2++;
            }
            else{
                if(i2==0){
                    i1++;
                }
                else{
                    i2= ls[i2-1];
                }
            }
        if(i2==n){
            return i1-n;
        }
        }
    return -1;
    }
}