class Trie {
    TrieNode root;
    public class TrieNode{
        boolean eow;
    TrieNode[] children = new TrieNode[26];
    
     
    public TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    public Trie() {
        root = new TrieNode(); 
        
    }
    public void insert(String word) {
        int len= word.length();
        int level=0;
        int idx=0;
        TrieNode curr= root;
        for(;level<len;level++){
            idx= word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new TrieNode();
                curr= curr.children[idx];
            }
        else{
            curr= curr.children[idx];
        }
        }
    curr.eow= true;
    }
    
    public boolean search(String word) {
        int len= word.length();
        int level=0;
        int idx=0;
        TrieNode curr= root;
        for(;level<len;level++){
            idx= word.charAt(level)-'a';
            if(curr.children[idx]==null){
            return false;
            }
        curr= curr.children[idx];
        }
    return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        int len= prefix.length();
        int level=0;
        int idx=0;
        TrieNode curr= root;
        for(;level<len;level++){
            idx= prefix.charAt(level)-'a';
            if(curr.children[idx]==null){
            return false;
            }
        curr= curr.children[idx];
        }
    return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */