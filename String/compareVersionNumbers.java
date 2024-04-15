class Solution {
    public int compareVersion(String version1, String version2) {
      int n= version1.length();
      int m= version2.length();
      int idx1=0;
      int idx2=0;

      while(idx1<n||idx2<m){
          int num1=0;
          int num2= 0;
          while(idx1<n&&version1.charAt(idx1)!='.'){
              num1= (num1*10)+(version1.charAt(idx1)-'0');
              idx1++;
          }
            while(idx2<m&&version2.charAt(idx2)!='.'){
              num2= (num2*10)+(version2.charAt(idx2)-'0');
              idx2++;
          }
        if(num1<num2){
            return -1;
        }
        if(num1>num2){
            return 1;
        }
      idx1++;
      idx2++;
      }
    return 0;
    }
}