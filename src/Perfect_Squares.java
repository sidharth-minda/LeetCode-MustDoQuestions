/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

import java.util.Arrays;

class Perfect_Squares {
    public int numSquares(int sum) {
        int num = (int) Math.sqrt(sum);
        int dp[] = new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=num;i++) {
            for(int j=1;j<=sum;j++) {
                if(j>=i*i)
                    dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
            }
        }
        return dp[sum];
    }
}
