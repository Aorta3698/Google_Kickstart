import java.util.*;

public class Solution{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++){
            System.out.printf("Case #%d: ", i);
            go();
        }
    }

    private static void go(){
        int I = scanner.nextInt();
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String s = scanner.next();

        x--; y--;
        BitSet[] xMap = new BitSet[M];
        BitSet[] yMap = new BitSet[N];
        Arrays.setAll(xMap, o -> new BitSet());
        Arrays.setAll(yMap, o -> new BitSet());
        xMap[x].set(y);
        yMap[y].set(x);
        for (char ch : s.toCharArray()){
            switch(ch){
                case 'E': y = xMap[x].nextClearBit(y); break;
                case 'W': y = xMap[x].previousClearBit(y); break;
                case 'N': x = yMap[y].previousClearBit(x); break;
                default : x = yMap[y].nextClearBit(x); break;
            };
            xMap[x].set(y);
            yMap[y].set(x);
        }
        System.out.printf("%d %d\n", x+1, y+1);
    }
}
