/*
    Given an array of integers nums and a positive integer k,
    find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

    Example 1:

    Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
    Output: True
    Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

    Note:
    1 <= k <= len(nums) <= 16.
    0 < nums[i] < 10000.

 */

import java.util.Arrays;

public class Partition_to_K_Equal_Sum_Subsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum%k != 0)
            return false;
        sum /= k;
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[n-1]  > sum)
            return false;
        while(n>0 && nums[n-1] == sum) {
            --n; --k;
        }
        int subsets[] = new int[k];
        return isPossible(subsets, nums, sum, n-1);
    }

    public boolean isPossible(int subsets[], int nums[], int sum, int idx) {
        if(idx < 0)
            return true;
        for(int i=0;i<subsets.length;i++) {
            if(subsets[i] + nums[idx] <= sum) {
                subsets[i] += nums[idx];
                if(isPossible(subsets, nums, sum, idx-1))
                    return true;
                subsets[i] -= nums[idx];
            }
            if(subsets[i] == 0)
                break;
        }
        return false;
    }
}
