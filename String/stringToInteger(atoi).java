class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
    
    int sign=1;
    
    long ans=0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(0)=='-'){
        sign=-1;
        }
        if(s.charAt(i)=='-'||s.charAt(i)=='+'){
            i++;
            if(i==s.length()||i-1!=0){ break;}
        }
        if(!Character.isDigit(s.charAt(i))||s.charAt(i)==' '){
            break;
        }
            ans*=10;
            ans+=(s.charAt(i)-'0');
        if(sign==1&&ans>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(sign==-1&&-1*ans<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
    }
    return (int)ans*sign;
    }
}