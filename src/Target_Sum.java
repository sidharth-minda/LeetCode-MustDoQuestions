/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.


Constraints:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 */


import java.util.Arrays;
public class Target_Sum {
    public int findTargetSumWays(int[] arr, int target) {
        int sum = Arrays.stream(arr).sum();
        sum -= target;
        if(sum%2==1 || sum<0)
            return 0;
        sum /= 2;
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for(int i: arr) {
            for(int j=sum;j>=i;j--) {
                dp[j] += dp[j-i];
            }
        }
        return dp[sum];
    }
}
