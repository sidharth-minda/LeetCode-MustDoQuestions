/*
A die simulator generates a random number from 1 to 6 for each roll. You introduced a constraint to the generator such that it cannot roll the number i more than rollMax[i] (1-indexed) consecutive times.

Given an array of integers rollMax and an integer n, return the number of distinct sequences that can be obtained with exact n rolls.

Two sequences are considered different if at least one element differs from each other. Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:

Input: n = 2, rollMax = [1,1,2,2,2,3]
Output: 34
Explanation: There will be 2 rolls of die, if there are no constraints on the die, there are 6 * 6 = 36 possible combinations. In this case, looking at rollMax array, the numbers 1 and 2 appear at most once consecutively, therefore sequences (1,1) and (2,2) cannot occur, so the final answer is 36-2 = 34.
Example 2:

Input: n = 2, rollMax = [1,1,1,1,1,1]
Output: 30

 */

public class Dice_Roll_Simulation {
    int dp[][];
    int rollmax[];
    int mod = (int) Math.pow(10,9) + 7 ;
    int last=0;
    public int dieSimulator(int n, int[] r) {
        dp = new int[n+1][16];
        rollmax = r;
        return dfs(n, 0);
    }

    public int dfs(int n,int times) {
        if(n==0)
            return 1;
        if(dp[n][times]!=0)
            return dp[n][times];

        long ans=0;
        for(int i=1;i<=6;i++) {
            if(i==last && times+1>rollmax[i-1])
                continue;
            int prev = last;
            last=i;
            ans = (ans + dfs(n-1, i==prev?times+1:1))%mod;
        }
        return dp[n][times] = (int)ans;
    }
}
