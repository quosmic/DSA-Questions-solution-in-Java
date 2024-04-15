class Solution
{
    public class Node{
        Node[] children=new Node[26];
        boolean eow;
        Node(){
            for(int i=0;i<26;i++){
                children[i]= null;
            }
        }
    }
    public Node root= new Node();
    public void insert(String str){
        Node curr=root;
        int len= str.length();
        for(int i=0;i<len;i++){
            int idx= str.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
        curr= curr.children[idx];
        }
    curr.eow= true;
    }
    public void addStrings(Node root, List<String> a, StringBuilder curr){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                curr.append((char)(i+'a'));
                if(!a.contains(curr.toString())){
                a.add(curr.toString());
                }
                addStrings(root.children[i],a,curr);
                curr.deleteCharAt(curr.length()-1);
                addStrings(root.children[i],a,curr);
            }
        }
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> a= new ArrayList<>();
        root= new Node();
        for(int i=0;i<s.length();i++){
            insert(s.substring(i));
        }
        addStrings(root,a,new StringBuilder(""));
        Collections.sort(a);
        return a;
    }
}