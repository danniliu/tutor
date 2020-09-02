package app.heap;

/**
 * Leetcode: a692. Top K Frequent Keywords
 * Amazon question: https://leetcode.com/discuss/interview-question/542597/
 * Additional Info: tag: heap, hash table; difficulty: medium 
 * ************************** Description:
    Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.

    The comparison of strings is case-insensitive.
    Multiple occurances of a keyword in a review should be considred as a single mention.
    If keywords are mentioned an equal number of times in reviews, sort alphabetically.
    Example 1:

    Input:
    k = 2
    keywords = ["anacell", "cetracular", "betacellular"]
    reviews = [
    "Anacell provides the best services in the city",
    "betacellular has awesome services",
    "Best services provided by anacell, everyone should use anacell",
    ]

    Output:
    ["anacell", "betacellular"]

    Explanation:
    "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
    Example 2:

    Input:
    k = 2
    keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
    reviews = [
    "I love anacell Best services; Best services provided by anacell",
    "betacellular has great services",
    "deltacellular provides much better services than betacellular",
    "cetracular is worse than anacell",
    "Betacellular is better than deltacellular.",
    ]

    Output:
    ["betacellular", "anacell"]

    Explanation:
    "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
 
* ************************** Analysis:
 * Time Complexity: 
 * Space Complexity: 
 */
import java.util.*;

public class TopKFrequentKeywords {
    public static String[] topKFrequent(String[] reviews, String[] keywords, int k) {

        //Assuming keywords are all in lower case, build the set
        Set<String> keySet = new HashSet<>(Arrays.asList(keywords));

        //build the hash table of keywords and their corresponding count in the reviews:
        Map<String, Integer> count = new HashMap<>();

        for(String review: reviews){
            StringTokenizer st = new StringTokenizer(review);
            while(st.hasMoreTokens()){
                String word = st.nextToken().toLowerCase();
                if (keySet.contains(word)) {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                }
            }
        }

        //build a heap, less frequent first:
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> count.get(a) == count.get(b)? b.compareTo(a) : count.get(a) - count.get(b)
        );

        for(String word: count.keySet()){
            pq.add(word);
            if(pq.size() > k) pq.remove();
        }

        String[] result = new String[k];
        int index = k-1;
        while(!pq.isEmpty()) {
            result[index] = pq.remove();
            index --;
        }
        return result;
        
    }
    public static void main(String[] args) throws Exception {
        /* Example 1:
        String[] reviews = {
            "Anacell provides the best services in the city",
            "betacellular has awesome services",
            "Best services provided by anacell, everyone should use anacell",
        };
        String[] keywords = {"anacell", "cetracular", "betacellular"};
        */
        //Example 2:
        String[] reviews = {
            "I love anacell Best services; Best services provided by anacell",
            "betacellular has great services",
            "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell",
            "Betacellular is better than deltacellular."
        };
        String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        
        String[] results = TopKFrequentKeywords.topKFrequent(reviews, keywords, 2);
        for(String word: results) {
            System.out.println(word);
        }
    }
}