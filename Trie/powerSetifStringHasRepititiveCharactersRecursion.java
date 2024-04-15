class Solution
{
    public void possibles(List<String> a, String s1, String s, int i){
        if(i==s.length()){
            if(s1!=""){
            a.add(s1);
            }
            return;
        }
    possibles(a,s1+s.charAt(i),s,i+1);
    possibles(a,s1,s,i+1);
        
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String>a= new ArrayList<>();
        possibles(a,"",s,0);
        Collections.sort(a);
        return a;
    }
}