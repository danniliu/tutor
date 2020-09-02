package app.trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root =  new TrieNode();
    }

    public void insert(String word){
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

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        char currChar;
        for (int i=0; i<word.length(); i++){
            currChar = word.charAt(i);
            if(node.containsKey(currChar)){
                node = node.get(currChar);
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args){
        Trie test = new Trie();
        test.insert("life");
        test.insert("live");

        System.out.println(test.search("live"));
    }
}