import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class _2_Keys_Keyboard {

    public static int minSteps(int n) {
        int dp[] = new int[1001];
        dp[2]=2;dp[3]=3;
        System.out.println(n);
        for(int i=4;i<=n;i++) {
            dp[i] = i;
            for(int j=2;j*j<=i;j++) {
                if(i%j==0) {
                    dp[i] = dp[i/j] + j;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        Scanner sc =new Scanner(System.in);
        System.out.println(minSteps(1000));
    }
}
