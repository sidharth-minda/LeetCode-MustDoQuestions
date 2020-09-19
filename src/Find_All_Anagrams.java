/*
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
    The order of output does not matter.

    Example 1:
    Input:
    s: "cbaebabacd" p: "abc"

    Output:
    [0, 6]

    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".
 */

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams {
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> ans = new ArrayList<Integer>();
        if(s1.length() > s2.length())
            return ans;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int i=0;i<s1.length();i++){
            ++freq1[s1.charAt(i)-'a'];
            ++freq2[s2.charAt(i)-'a'];
        }
        for(int i=s1.length();i<s2.length();i++) {
            if(matches(freq1, freq2))
                ans.add(i-s1.length());
            ++freq2[s2.charAt(i)-'a'];
            --freq2[s2.charAt(i-s1.length())-'a'];
        }
        if(matches(freq1, freq2))
            ans.add(s2.length()-s1.length());
        return ans;
    }

    public boolean matches(int a[], int b[]) {
        for(int i=0;i<26;i++) {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
}
