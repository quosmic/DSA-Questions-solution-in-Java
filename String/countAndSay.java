class Solution {
  
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s1= countAndSay(n-1);
        StringBuilder sb= new StringBuilder("");
        for(int i=0;i<s1.length();i++){
            int count=1;
            while(i<s1.length()-1&&s1.charAt(i)==s1.charAt(i+1)){
                i++;
                count++;
            }
        sb.append(String.valueOf(count));
        sb.append(s1.charAt(i));
        }
    return sb.toString();
    }
}