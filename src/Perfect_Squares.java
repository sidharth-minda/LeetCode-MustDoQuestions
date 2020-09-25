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

public class Perfect_Squares {
    public int numSquares(int n) {
        int size = (int)Math.sqrt(n);
        int dp[] = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = i;
            for(int j=2;j<=size;j++) {
                if(j*j > i)
                    break;
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }
}
