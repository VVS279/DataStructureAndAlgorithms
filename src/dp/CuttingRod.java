package dp;

import java.util.Arrays;
import java.util.List;

public class CuttingRod {

  public static long getWays(int length, List<Long> c) {
    long[] dp = new long[length + 1];

      for (int i = 1; i <= length; i++) {
        long max_val = Integer.MIN_VALUE;
        for (int j = 0; j < i; j++) {
          max_val = Math.max(max_val,
                               c.get(j) + dp[i-j-1]);
        }
        dp[i] = max_val;
      }
    return dp[length];
  }
  
  public static void main(String[] args) {
    List<Long>  c = Arrays.asList(1L, 5L, 8L,9L,10L,17L, 17L, 20L);
    System.out.println(getWays(c.size(), c));
  }
}
