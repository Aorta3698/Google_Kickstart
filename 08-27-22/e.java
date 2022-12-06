import java.util.*;

public class Solution{
    static Scanner in = new Scanner(System.in);
    static int M = (int)1e9+7;
    public static void main(String[] args){
        int t = in.nextInt();
        for (int i = 1; i <= t; i++){
            System.out.printf("Case #%d: ", i);
            go();
        }
    }

    private static void go(){
        int A = in.nextInt();
        int B = in.nextInt();
        long N = in.nextLong();
        int K = in.nextInt();
        long[] a = new long[K];
        long[] b = new long[K];
        long ans = 0;
        for (int i = 1; i <= Math.min(K, N); i++){
            int amod = eval(i, A, K);
            int bmod = eval(i, B, K);
            long add = N / K + (N % K >= i? 1 : 0);
            a[amod] += add;
            b[bmod] += add;
            a[amod] %= M;
            b[bmod] %= M;
            if ((amod + bmod) % K == 0){
                ans -= add;
            }
        }
        ans %= M;
        for (int i = 0; i < K; i++){
            ans += a[i] * b[(K-i)%K];
            ans %= M;
        }
        System.out.println(ans);
    }

    private static int eval(int v, int e, int K){
        long ans = 1 % K, val = v % K;
        for (; e > 0; e >>= 1){
            if ((e & 1) == 1){
                ans *= val;
                ans %= K;
            }
            val *= val;
            val %= K;
        }
        return (int)ans;
    }
}
