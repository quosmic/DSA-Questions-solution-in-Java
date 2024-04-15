class Solution {
    public boolean isValid(String s) {
     Stack<Character> s1= new Stack<>();
     for(int i=0;i<s.length();i++){
         char curr= s.charAt(i);
         if(curr=='('||curr=='['||curr=='{'){
             s1.push(curr);
         }
     else{
     if(s1.isEmpty()){
         return false;
     }
      if((curr==')'&&s1.peek()=='(')||(curr==']'&&s1.peek()=='[')||(curr=='}'&&s1.peek()=='{')){
         s1.pop();
     }
     else return false;
     }
     }   
    if(s1.isEmpty()){
        return true;
    }
    else 
    return false;
    
    }
}