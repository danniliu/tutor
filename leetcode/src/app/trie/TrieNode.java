package app.trie;

public class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;
    private final int R = 26;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }

    public TrieNode get(char ch){
        return links[ch-'a'];
    }

    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}