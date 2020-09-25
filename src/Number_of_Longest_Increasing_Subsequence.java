import java.util.Arrays;

public class Number_of_Longest_Increasing_Subsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        int dp[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j] + 1 == dp[i])
                        count[i] += count[j];
                    else if(dp[j] + 1 > dp[i]) {
                        count[i] = count[j];
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        int c = 0;
        for(int i=0;i<n;i++) {
            if(dp[i] == max)
                c += count[i];
        }
        return c;
    }
}
