/*
    Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
    such that the sum of elements in both subsets is equal.

    Note:
    Each of the array element will not exceed 100.
    The array size will not exceed 200.


    Example 1:
    Input: [1, 5, 11, 5]

    Output: true

    Explanation: The array can be partitioned as [1, 5, 5] and [11].

 */

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 ==1)
            return false;
        sum /= 2;
        boolean dp[] = new boolean[sum+1];
        dp[0] = true;
        for(int i: nums) {
            for(int j=sum;j>=i;j--) {
                dp[j] = dp[j] || dp[j-i];
            }
        }
        return dp[sum];
    }
}
