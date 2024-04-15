class Solution {
    static boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    public void partP(String s, List<String> list, List<List<String>> list1, int i, int j){
        if(i>j){
            list1.add(new ArrayList<>(list));
            return;
        }
        for(int k=i;k<=j;k++){
            if(isPalindrome(i,k,s)){
                list.add(s.substring(i,k+1));
                partP(s,list,list1,k+1,j);
                list.remove(list.size()-1);
            }
            }
        }

    public List<List<String>> partition(String s) {
        List<List<String>> list1 = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partP(s,list,list1,0,s.length()-1);
        return list1;
    }
}