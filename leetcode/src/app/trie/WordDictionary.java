package app.trie;
/**
 * Leetcode: 211. Add and Search Word - Data structure design
 * Reference: https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * Additional Info: tag: trie; difficulty: medium 
 * ************************** Description:
    Design a data structure that supports the following two operations:
    void addWord(word)
    bool search(word)
    search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

    Example:

    addWord("bad")
    addWord("dad")
    addWord("mad")
    search("pad") -> false
    search("bad") -> true
    search(".ad") -> true
    search("b..") -> true
    Note:
    You may assume that all words are consist of lowercase letters a-z.
 * ************************** Analysis:
 */

class WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        char currChar;
        for (int i=0; i<word.length(); i++){
            currChar = word.charAt(i);
            if(!node.containsKey(currChar)){
                node.put(currChar, new TrieNode());
            }
            node = node.get(currChar);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word){
        TrieNode node = root;
        char currChar;
        for (int i=0; i<word.length(); i++){
            currChar = word.charAt(i);
            if(currChar == '.') {
                if(i == word.length()-1) return true;
                else continue;
            }
            if(node.containsKey(currChar)){
                node = node.get(currChar);
            } else {
                return false;
            }
        }
        return node!=null && node.isEnd();
    }

    public static void main(String[] args){
        WordDictionary test = new WordDictionary();
        test.addWord("worddictionary");
        test.addWord("bad");

        System.out.println(test.search("b.d"));  //this is the wrong test case
    }
    
}