/*
Given an array, strs, with strings consisting of only 0s and 1s. Also two integers m and n.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.



Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001","1","0".
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */


public class Ones_and_Zeroes {

    public int findMaxForm(String[] str, int m, int n) {
        int len = str.length;
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<len;i++) {
            int ones = (int) str[i].chars().mapToObj(x->(char)x).filter(x->x=='1').count();
            int zeros = str[i].length() - ones;
            for(int j=m;j>=zeros;j--) {
                for(int k=n;k>=ones;k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
