public class Longest_Palindromic_Subsequence {

    public int longestPalindromeSubsequence(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int i=1;i<=n;i++)   dp[i][i] = 1;

        for(int i=n;i>0;i--) {
            for(int j=i+1;j<=n;j++) {
                if(s.charAt(i-1) == s.charAt(j-1))
                    dp[i][j] = 2 + dp[i+1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[1][n];
    }
}
