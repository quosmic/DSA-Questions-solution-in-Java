class Solution {
    // here we have used Hashmap for memoization because we wanted to save 
    //the string s with its response.
    HashMap<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)){
            return true;
        }
    if(map.containsKey(s)){
        return map.get(s);
    }
    for(int i=0;i<s.length();i++){
        String str = s.substring(0,i);
        if(wordDict.contains(str) && wordBreak(s.substring(i),wordDict)){
            map.put(s,true);
            return true;
        }
    }
    map.put(s,false);
    return false;
    }
}