import java.util.* ;
import java.io.*; 

class Solution {
  public static class Node{
    Node[] children= new Node[26];
    boolean eow;
    Node(){
      for(int i=0;i<26;i++){
        children[i]=null;
              }
    eow= false;
    }
  }
  private static Node root= new Node();
  public static void insert(String str){
    int len= str.length();
    Node curr= root;
    for(int i=0;i<len;i++){
      int idx= str.charAt(i)-'a';
      if(curr.children[idx]==null){
        curr.children[idx]= new Node();
      }
    curr= curr.children[idx];
    }
  curr.eow= true;
  }
  public static void completeAction(Node root, StringBuilder curr, String[] ans){
    for(int i=0;i<26;i++){
      if(root.children[i]!=null&&root.children[i].eow==true){
        curr.append((char)(i+'a'));
        if(curr.length()>ans[0].length()){
          ans[0]= curr.toString();
        }
      
        completeAction(root.children[i], curr,ans);
        curr.deleteCharAt(curr.length()-1);
      }
    }
  }
  public static String completeString(int n, String[] a) {
    // Write your code here.
  root= new Node();
  for(int i=0;i<n;i++){
    insert(a[i]);
  }
   String[] ans= new String[1];
   ans[0]="";
   completeAction(root,new StringBuilder(""), ans);
    if(ans[0]==""){
        return "None";
    }
  return ans[0];

  } 
}