package app.heap;

/**
 * Leetcode: 692. Top K Frequent Words
 * Reference: https://leetcode.com/problems/top-k-frequent-words/
 * Additional Info: tag: heap, hash table; difficulty: medium 
 * ************************** Description:
    Given a non-empty list of words, return the k most frequent elements.

    Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

    Example 1:
    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    Output: ["i", "love"]
    Explanation: "i" and "love" are the two most frequent words.
        Note that "i" comes before "love" due to a lower alphabetical order.
    Example 2:
    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    Output: ["the", "is", "sunny", "day"]
    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
        with the number of occurrence being 4, 3, 2 and 1 respectively.
    Note:
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Input words contain only lowercase letters.
    Follow up:
    Try to solve it in O(n log k) time and O(n) extra space.
 * ************************** Analysis:
    This solution use hashtable and heap.
    Time: O(NLogk)
    Space: O(N)
* ***************************** Notes:
    Priority Queue = A FIFO data structure that serves elements with the highest priorities first
    before elements with lower priority.

    */
import java.util.*;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        //build the hash table of word and the corresponding count
        //Time: O(N)
        //space for count: O(N)
        Map<String, Integer> count = new HashMap<>();
        for(String word: words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        //populate a min heap using the count map, 
        //so each adding that exceeds K the lower count word is removed
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> count.get(a).equals(count.get(b)) ? b.compareTo(a) : count.get(a) - count.get(b) ); //:)
        
        for(String word: count.keySet()){
            //time: each add is O(logk) --> total is O(Nlog(k))
            //space: O(k)
            pq.add(word);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        
        //Construct a list and reverse the order before return
        //time: O(k), space is O(K)
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.remove());
        }
        Collections.reverse(result);  //TIme: O(k)
        
        return result;
        
    }


    public static void main(String[] args) throws Exception {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> result = TopKFrequentWords.topKFrequent(words, 2);
        for(String word: result) {
            System.out.println(word);
        }
    }
}