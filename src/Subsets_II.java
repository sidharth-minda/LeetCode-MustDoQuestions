/*
    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: [1,2,2]
    Output:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    public void dfs(int nums[], List<Integer> arr, int idx) {
        ans.add(arr);
        if(idx == nums.length)
            return;
        for(int i=idx;i<nums.length;i++) {
            if(i != idx && nums[i] == nums[i-1])
                continue;
            List<Integer> temp = new ArrayList<>(arr);
            temp.add(nums[i]);
            dfs(nums, temp, i+1);
        }
    }
}
