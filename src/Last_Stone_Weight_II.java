import java.util.*;
class Last_Stone_Weight_II {

    public int lastStoneWeightII(int[] arr) {
        int n = arr.length;
        if(n==1)
            return arr[0];
        int total = Arrays.stream(arr).sum();
        int sum = total/2;
        int dp[] = new int[sum+1];
        for(int i=0;i<n;i++) {
            for(int j=sum;j>=arr[i];j--) {
                dp[j] = Math.max(dp[j], dp[j-arr[i]] + arr[i]);
            }
        }
        return total-2*dp[sum];
    }
}
