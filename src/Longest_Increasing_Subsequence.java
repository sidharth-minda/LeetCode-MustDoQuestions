import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i] && dp[j] >= dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

