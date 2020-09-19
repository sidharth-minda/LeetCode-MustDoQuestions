 /*

    Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
    In other words, one of the first string's permutations is the substring of the second string.

        Example 1:
        Input: s1 = "ab" s2 = "eidbaooo"
        Output: True
        Explanation: s2 contains one permutation of s1 ("ba").

        Example 2:
        Input:s1= "ab" s2 = "eidboaoo"
        Output: False

        Constraints:
        The input strings only contain lower case letters.
        The length of both given strings is in range [1, 10,000].
 */

public class Permutation_in_String {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int i=0;i<s1.length();i++) {
            ++freq1[s1.charAt(i)-'a'];
            ++freq2[s2.charAt(i)-'a'];
        }
        for(int i=s1.length();i<s2.length();i++) {
            if(matches(freq1, freq2))
                return true;
            ++freq2[s2.charAt(i)-'a'];
            --freq2[s2.charAt(i-s1.length())-'a'];
        }
        if(matches(freq1, freq2))
            return true;
        return false;
    }

    public boolean matches(int a[], int b[]) {
        for(int i=0;i<26;i++) {
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }
}
