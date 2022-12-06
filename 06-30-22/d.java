import java.io.*;
import java.util.*;
import java.math.*;

// NOTE: Problem D - Irregular Expressions
// NOTE: Time Complexity:  O(N^2)
// NOTE: Space Complexity: O(N^2)
public class Solution {
    private static boolean containsSpell(String A) {
        int n = A.length();
        int p = 57;
        int M = (int)1e9+7;
        Map<Long, Integer> map = new HashMap<>();
        int[] vcnt = new int[n];
        for (int i = 0; i < n; i++){ // generate a vowel count array so we can do the vowel check in O(1)
            vcnt[i] = vcnt[Math.max(i-1,0)]+(isVowel(A.charAt(i))? 1 : 0);
        }
        for (int i = 0; i < n; i++){ // greedily take the last substring is the optimal play
            long hash = 0;
            for (int j = i; j < n; j++){
                hash = (p*hash+A.charAt(j)-'a'+1)%M;
                map.put(hash, i);
            }
        }
        for (int i = 0; i < n; i++){
            long hash = 0;
            for (int j = i, count = 0; j < n; j++){
                hash = (p*hash+A.charAt(j)-'a'+1)%M;
                if (isVowel(A.charAt(j))){
                    count++;
                }
                if (count < 2){
                    continue;
                }
                if (map.get(hash)!=i&&vcnt[map.get(hash)-1]-vcnt[j]>=1){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= caseNum; ++t) {
            String expression = in.next();
            System.out.println("Case #" + t + ": " + (containsSpell(expression) ? "Spell!" : "Nothing."));
        }
    }
}
