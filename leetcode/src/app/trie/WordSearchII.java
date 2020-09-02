package app.trie;
/**
 * Leetcode: 212. Word Search II
 * Reference: https://leetcode.com/problems/word-search-ii/
 * Additional Info: tag: trie; difficulty: hard 
 * ************************** Description:
    Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
Example:
Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Note:
All inputs are consist of lowercase letters a-z.
The values of words are distinct.
 * ************************** Analysis:
  1.Time: O( M (4 ⋅ (3^(L-1)) )), where MM is the number of cells in the board and LL is the maximum length of words.
    --> loops over all the cells in the board, therefore we have MM as a factor
    --> at most 4 directions to explore, during the following exploration, we have at most 3 neighbor cells (excluding the cell where we come from) to explore. As a result, we would traverse at most (4 ⋅ (3^(L-1)) cells during the backtracking exploration.
    --> Note that, the above time complexity is estimated under the assumption that the Trie data structure would not change once built. If we apply the optimization trick to gradually remove the nodes in Trie, we could greatly improve the time complexity, since the cost of backtracking would reduced to zero once we match all the words in the dictionary, i.e. the Trie becomes empty.

  2.Space: O(N), where NN is the total number of letters in the dictionary:
    The main space consumed by the algorithm is the Trie data structure we build. In the worst case where there is no overlapping of prefixes among the words, the Trie would have as many nodes as the letters of all words. And optionally, one might keep a copy of words in the Trie as well. As a result, we might need 2N2N space for the Trie.

  3. Optimization:
    The idea is motivated by the fact that the time complexity of the overall algorithm sort of depends on the size of the Trie. For a leaf node in Trie, once we traverse it (i.e. find a matched word), we would no longer need to traverse it again. As a result, we could prune it out from the Trie.

    Gradually, those non-leaf nodes could become leaf nodes later, since we trim their children leaf nodes. In the extreme case, the Trie would become empty, once we find a match for all the words in the dictionary. This pruning measure could reduce up to 50\%50% of the running time for the test cases of the online judge.
 */

import java.util.*;
  
class WordSearchII {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();
  
    public List<String> findWords(char[][] board, String[] words) {
  
      // Step 1). Construct the Trie
      TrieNodeII root = new TrieNodeII();
      for (String word : words) {
        TrieNodeII node = root;
  
        for (Character letter : word.toCharArray()) {
          if (node.children.containsKey(letter)) {
            node = node.children.get(letter);
          } else {
            TrieNodeII newNode = new TrieNodeII();
            node.children.put(letter, newNode);
            node = newNode;
          }
        }
        node.word = word;  // store words in Trie
      }
  
      this._board = board;
      // Step 2). Backtracking starting for each cell in the board
      for (int row = 0; row < board.length; ++row) {
        for (int col = 0; col < board[row].length; ++col) {
          if (root.children.containsKey(board[row][col])) {
            backtracking(row, col, root);
          }
        }
      }
  
      return this._result;
    }
    
    private void backtracking(int row, int col, TrieNodeII parent) {
      Character letter = this._board[row][col];
      TrieNodeII currNode = parent.children.get(letter);
  
      // check if there is any match
      if (currNode.word != null) {
        this._result.add(currNode.word);
        currNode.word = null;
      }
  
      // mark the current letter before the EXPLORATION
      this._board[row][col] = '#';
  
      // explore neighbor cells in around-clock directions: up, right, down, left
      int[] rowOffset = {-1, 0, 1, 0};
      int[] colOffset = {0, 1, 0, -1};
      for (int i = 0; i < 4; ++i) {
        int newRow = row + rowOffset[i];
        int newCol = col + colOffset[i];
        if (newRow < 0 || newRow >= this._board.length || newCol < 0
            || newCol >= this._board[0].length) {
          continue;
        }
        if (currNode.children.containsKey(this._board[newRow][newCol])) {
          backtracking(newRow, newCol, currNode);
        }
      }
  
      // End of EXPLORATION, restore the original letter in the board.
      this._board[row][col] = letter;
  
      // Optimization: incrementally remove the leaf nodes  ???
      if (currNode.children.isEmpty()) {
        parent.children.remove(letter);
      }
    }

    public static void main(String[] args){
      char[][] board = {
        {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}
      };

      String[] words = {"oath","pea","eat","rain"};

      WordSearchII tool = new WordSearchII();
      List<String> output = tool.findWords(board, words);

      for(String word: output){
        System.out.print(word);
        System.out.println();
      }
    }
  }
  
