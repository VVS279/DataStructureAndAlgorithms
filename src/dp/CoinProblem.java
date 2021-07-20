package dp;

import java.util.Arrays;
import java.util.List;

public class CoinProblem {

  public static long getWays(int sum, List<Long> c) {
    int length = c.size();
    long[][] dp = new long[sum + 1][length + 1];

    for (int i = 0; i <= length; i++) {
      dp[0][i] = 1;
    }

    /**
     * for (int i = 1; i <= sum; i++) { dp[i][0] = 0; }
     */

    for (int i = 1; i <= sum; i++) {
      for (int j = 1; j <= length; j++) {
        dp[i][j] = dp[i][j - 1];
        if (i >= c.get(j - 1)) {
          dp[i][j] = dp[i][j] + dp[i - c.get(j - 1).intValue()][j];
        }
      }
    }

    return dp[sum][length];
  }
  
  public static void main(String[] args) {
    List<Long>  c = Arrays.asList(8L,3L,1L,2L);
    System.out.println(getWays(3, c));
  }
}
