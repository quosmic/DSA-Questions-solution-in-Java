import java.util.* ;
import java.io.*; 
/********************************************************

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean isEnd;

    TrieNode() {
        isEnd = false;

        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
};

*********************************************************/
public class Solution {

    public static TrieNode deleteWord(TrieNode root, String word) {
        // WRITE YOUR CODE HERE
        if(root==null){
            return null;
        }
        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            int num= word.charAt(i)-'a';
            if(curr.children[num]==null){
                break;
            }
        curr= curr.children[num];
        }
    curr.isEnd= false;
    return root;
    }

}