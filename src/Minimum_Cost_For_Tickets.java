import java.util.*;
public class Minimum_Cost_For_Tickets {
    public static int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[366];
        Set<Integer> set = new HashSet<>(days.length);
        for(int i:days) set.add(i);
        for(int i=1;i<=365;i++) {
            if(!set.contains(i)) {
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = dp[i-1] + costs[0];
            dp[i] = Math.min(dp[i], (i<7?0:dp[i-7]) + costs[1]);
            dp[i] = Math.min(dp[i], (i<30?0:dp[i-30]) + costs[2]);
        }
        return dp[365];
    }
    public static void main(String args[]) {
        Scanner sc =new Scanner(System.in);
        int days[] = {1,2,3,4,5,6,7,8,9,10,30,31};
        int costs[] = {2,7,15};
        System.out.println(mincostTickets(days, costs));
    }
}