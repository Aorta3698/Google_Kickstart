import java.util.*;

// NOTE: Problem C - Building Palindromes
// NOTE: Time Complexity:  O(N) for processing, O(1) for each query.
// NOTE: Space Complexity: O(N)
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int tc = 1; tc <= testCaseCount; ++tc) {
            int numberOfBlocks = scanner.nextInt();
            int numberOfQuestions = scanner.nextInt();
            String blockString = scanner.next();
            char[] blocks = new char[numberOfBlocks];
            for (int i = 0; i < numberOfBlocks; ++i) {
                blocks[i] = blockString.charAt(i);
            }

            // START HERE.
            int n = blocks.length;
            int[] parity = new int[n]; // we only care about the parity
            for (int i = 0; i < n; i++){
                parity[i] = parity[i==0?0:i-1]^1<<(blocks[i]-'A');
            }
            int palindromeCount = 0;
            for (int i = 0; i < numberOfQuestions; ++i) {
                int left = scanner.nextInt()-1;
                int right = scanner.nextInt()-1;
                int ans = parity[right]^(left==0?0:parity[left-1]);
                if ((ans&(ans-1))==0) { // as long as it is a power of 2, including 0, then it's ok.
                    ++palindromeCount;
                }
            }

            System.out.println("Case #" + tc + ": " + palindromeCount);
        }
    }
}
