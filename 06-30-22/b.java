import java.util.*;
import java.math.*;

// NOTE: Problem B - Sherlock and Parentheses
// NOTE: Time Complexity:  O(1)
// NOTE: Space Complexity: O(1)
public class Solution {

  private static long findMaxNumOfBalancedSubstrings(int l, int r) {
      int pairs = Math.min(l, r); // the optimal play is as many () as possible.
      return 1L*pairs*(pairs+1)/2;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // Input number of test cases
    int testCaseCount = in.nextInt();
    for (int tc = 1; tc <= testCaseCount; ++tc) {
      // Input total number of left and right parentheses
      int l = in.nextInt();
      int r = in.nextInt();

      System.out.println("Case #" + tc + ": " + findMaxNumOfBalancedSubstrings(l, r));
    }
  }
}
