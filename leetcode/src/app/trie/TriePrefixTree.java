package app.trie;
/**
* Leetcode: 208. Implement Trie (prefix Tree)
 * Reference: https://leetcode.com/problems/implement-trie-prefix-tree/
 * Additional Info: tag: trie; difficulty: medium 
 * ************************** Description:
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */


public class TriePrefixTree {
       Node head;

    public TriePrefixTree() {
        this.head = new Node('\0');
    }
    
    public void insert(String word) {
        if (word == null) return;
        
        Node curr = head;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null){
                curr.children[c-'a'] = new Node(c);
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
        
    }
    
    public boolean search(String word) {
        Node res = getLastNode(word);
        if (res == null) {
            return false;
        }
        return res.isWord? true : false;
    }
    
    public boolean startsWith(String prefix) {
        Node res = getLastNode(prefix);
        return res == null? false : true;
    }
    // return the last trie node for the word
    private Node getLastNode(String word){
        if (word == null) return null;
        Node curr = head;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) return null;
            curr = curr.children[c-'a'];
        }
        
        return curr;
    }
    
    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;
        
        public Node(char c){
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}
