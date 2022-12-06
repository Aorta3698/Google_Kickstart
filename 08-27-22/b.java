import java.util.*;

public class Solution {

  public static int numberOfRecordBreakingDays(int numberOfDays, int[] visitors) {
    int recordBreakingDays = 0;

    // TODO: implement logic to calculate the number of record-breaking days
    for (int i = 0, max = -1; i < numberOfDays; i++){
        if ((i == numberOfDays-1 || visitors[i] > visitors[i+1]) && visitors[i] > max){
            recordBreakingDays++;
        }
        max = Math.max(max, visitors[i]);
    }

    return recordBreakingDays;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Get number of test cases in input
    int testCaseCount = scanner.nextInt();
    // Iterate through test cases
    for (int tc = 1; tc <= testCaseCount; ++tc) {
      // Get number of days for this test case
      int numberOfDays = scanner.nextInt();
      // Get attendance for each day
      int[] visitorsPerDay = new int[numberOfDays];
      for (int d = 0; d < numberOfDays; ++d) {
        visitorsPerDay[d] = scanner.nextInt();
      }
      // Print results
      int answer = numberOfRecordBreakingDays(numberOfDays, visitorsPerDay);
      System.out.println("Case #" + tc + ": " + answer);
    }
  }
}
