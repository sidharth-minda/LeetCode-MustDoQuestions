/*

    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

*/

import java.util.*;

public class Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            if(!map.containsKey(str))
                map.put(str, new ArrayList<String>());
            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
