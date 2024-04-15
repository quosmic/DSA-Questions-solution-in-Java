class Solution {
    public String longestPalindrome(String s) {
       
       String maxi= "";
       if(s.length()<=1){
           return s;
       } 
        for(int i=1;i<s.length();i++){
            //odd length
            int low= i;
            int high= i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low<0||high>=s.length()){
                    break;
                }
            }
                String s1= s.substring(low+1,high);
                if(s1.length()>maxi.length()){
                    maxi= s1;
                } 
        low= i-1;
        high= i;
        while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low<0||high>=s.length()){
                    break;
                }
        }
        String s2= s.substring(low+1,high);
         if(s2.length()>maxi.length()){
                    maxi= s2;
                } 
        }
    return maxi;
    }
}