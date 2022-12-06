import java.util.*;

// NOTE: Problem A - Sample Problem
// NOTE: Time Complexity:  O(N) where N = number of bags
// NOTE: Space Complexity: O(1)
public class Solution {
    public static int solve(int[] A, int k){
        int sum = Arrays.stream(A).sum();
        return sum - sum/k*k; // or just sum%k
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        for (int i = 1; i <=cnt; i++){
            int bags = in.nextInt();
            int kids = in.nextInt();
            int[] candies = new int[bags];
            for (int j = 0; j < bags; j++){
                candies[j]=in.nextInt();
            }
            System.out.printf("Case #%d: %d\n", i, solve(candies, kids));
        }
    }
}
