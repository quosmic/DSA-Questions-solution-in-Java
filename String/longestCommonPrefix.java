class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len= Integer.MAX_VALUE;
        String str1= "";
        for(int i=0;i<strs.length;i++){
            String str= strs[i];
            if(str.length()<len){
                len= str.length();
                str1= str;
            }
        }
    StringBuilder sb= new StringBuilder("");
    for(int i=0;i<str1.length();i++){
        char ch= str1.charAt(i);
        int flag=0;
        for(String sm: strs){
            if(sm.charAt(i)!=ch){
                flag=1;
                break;
            }
        }
            if(flag==0){
            sb.append(str1.charAt(i));    
            }
            else{
                break;
            }
    }
    return sb.toString();
    }
}