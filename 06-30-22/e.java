import java.io.*;
import java.util.*;
import java.math.*;

//NOTE Problem E: Parcels
//NOTE Time Complexity:  O(MN*log(M+N))
//NOTE Space Complexity: O(MN)
public class Solution {
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int MAX = (int)1e9;
    static int MIN = (int)-1e9;
    private static int minimumDeliveryTime(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (A[i][j]==1){
                    queue.offer(new int[]{i, j});
                    A[i][j]=-1;
                }
            }
        }
        if (queue.isEmpty()){ // edge case ...
            return n/2+m/2;
        }
        int d = 1;
        while(!queue.isEmpty()){ // generate a distance map
            for (int sz = queue.size(); sz > 0; sz--){
                int[] top = queue.poll();
                for (int i = 0; i < 4; i++){
                    int x = top[0]+dx[i];
                    int y = top[1]+dy[i];
                    if (x < 0 || y < 0 || x == m || y == n || A[x][y]!=0){
                        continue;
                    }
                    A[x][y]=d;
                    queue.offer(new int[]{x, y});
                }
            }
            d++;
        }
        int lo = 0, hi = m+n;
        while(lo < hi){ // then we binary search for the answer
            int mid = (lo+hi)>>1;
            if (ok(mid, A)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }

    // NOTE
    // One dimensionality of manhatten distance as per
    // https://cs.stackexchange.com/questions/104307/minimizing-the-maximum-manhattan-distance
    //
    // and its proof
    // https://cs.stackexchange.com/questions/106289/can-someone-explain-this-formula-for-calculating-manhattan-distance
    private static boolean ok(int max, int[][] A){
        int m = A.length;
        int n = A[0].length;
        int[] borders = new int[]{MAX, MIN, MAX, MIN};
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (A[i][j]>max){
                    borders[0]=Math.min(borders[0], i+j);
                    borders[1]=Math.max(borders[1], i+j);
                    borders[2]=Math.min(borders[2], i-j);
                    borders[3]=Math.max(borders[3], i-j);
                }
            }
        }
        int radius=MAX;
        for (int i = 0; i < m; i++){
            for (int j = 0 ; j<n; j++){
                radius=Math.min(max(i+j-borders[0], borders[1]-i-j, i-j-borders[2], borders[3]-(i-j)), radius);
            }
        }
        return radius <= max;
    }

    private static int max(int... a){
        int ans = 0;
        for (int i = 0; i < a.length; i++){
            ans = Math.max(ans, a[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; ++testCase) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int[][] deliveryOffices = new int[R][C];

            for (int row = 0; row < R; ++row) {
                String line = scanner.next();
                for (int col = 0; col < C; ++col) {
                    deliveryOffices[row][col] = line.charAt(col) - '0'; // converts char to int
                }
            }

            System.out.println("Case #" + testCase + ": " + minimumDeliveryTime(deliveryOffices));
        }
    }
}
