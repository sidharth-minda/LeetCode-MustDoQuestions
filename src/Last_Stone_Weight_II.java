import java.util.*;
class Last_Stone_Weight_II {

    public int lastStoneWeightII(int[] arr) {
        int n = arr.length;
        int total = Arrays.stream(arr).sum();
        int sum = total/2;
        int dp[][] = new int[n+1][sum+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sum;j++) {
                dp[i][j] = dp[i-1][j];
                if(j-arr[i-1] >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-arr[i-1]] + arr[i-1]);
            }
        }
        return total - 2*dp[n][sum];
    }
}
