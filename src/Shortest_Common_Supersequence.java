/*
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.

(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)



Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shortest_Common_Supersequence {

    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        for(char c : lcs(str1, str2)) {
            while(str1.charAt(i)!=c)
                sb.append(str1.charAt(i++));
            while(str2.charAt(j)!=c)
                sb.append(str2.charAt(j++));
            sb.append(c);
            ++i; ++j;
        }
        return sb.toString() + str1.substring(i) + str2.substring(j);
    }

    public List<Character> lcs(String a, String b) {
        int m = a.length(), n = b.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(a.charAt(i-1)==b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        int i=m, j=n;
        List<Character> str = new ArrayList<>();
        while(i>0 && j>0) {
            if(a.charAt(i-1)==b.charAt(j-1)) {
                str.add(a.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
                --i;
            else
                --j;
        }
        Collections.reverse(str);
        return str;
    }
}
