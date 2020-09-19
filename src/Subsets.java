/*
    Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: nums = [1,2,3]
    Output:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]

 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        dfs(new ArrayList<>(), 0, nums);
        return ans;
    }
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(List<Integer> arr, int idx, int nums[]) {
        if(idx == nums.length)
            return;
        for(int i=idx;i<nums.length;i++) {
            List<Integer> temp = new ArrayList<>(arr);
            temp.add(nums[i]);
            ans.add(temp);
            dfs(temp, i+1, nums);
        }
    }
}
