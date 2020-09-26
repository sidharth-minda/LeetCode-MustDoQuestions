/*
You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.



Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation:
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation:
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 */

public class Number_of_Dice_Rolls_With_Target_Sum {
    public int numRollsToTarget(int d, int f1, int target) {
        int mod = (int) Math.pow(10,9) + 7;
        int dp[][] = new int[d+1][target+1];
        dp[0][0] = 1;
        for(int i=1;i<=d;i++) {
            for(int j=1;j<=target;j++) {
                for(int f=1;f<=f1;f++) {
                    if(j>=f)
                        dp[i][j] = (dp[i][j]+ dp[i-1][j-f]) % mod;
                }
            }
        }
        return dp[d][target];
    }
}
