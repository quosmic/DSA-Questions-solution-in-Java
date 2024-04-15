class Solution {
    public int[] lps(String str){
    int prefix=0;
    int suffix= 1;
    int n= str.length();
    int[] arr= new int[n];
    while(suffix<n){
        if(str.charAt(suffix)==str.charAt(prefix)){
            arr[suffix]= prefix+1;
            prefix++;
            suffix++;
        }
        else{
            if(prefix==0){
                arr[suffix]=0;
                suffix++;
            }
            else{
                prefix= arr[prefix-1];
            }
        }
    }    
    return arr;
    }
    public int repeatedStringMatch(String a, String b) {
    StringBuilder sb= new StringBuilder(a);
    int count=1;
    while(sb.length()<b.length()){
        sb.append(a);
        count++;
    }    
   if (kmp(sb.toString(), b) != -1) {
            return count;
        }
        sb.append(a);
        return kmp(sb.toString(), b) != -1 ? count+1 : -1;
    }
    public int kmp(String s, String s1){
       int m= s.length();
       int n= s1.length();
       int[] ps= lps(s1);
       int first=0;
       int second=0;
       while(first<m){
           if(s.charAt(first)==s1.charAt(second)){
               first++;
               second++;
           }
        else{
            if(second==0){
                first++;
            }
            else{
                second= ps[second-1];
            }
        }
       if(second==n){
           return first-n;
       }
       }
    return -1;
    }
}