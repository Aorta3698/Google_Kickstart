import java.util.*;

public class Solution{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        int t = in.nextInt();
        for (int i = 1; i <= t; i++){
            System.out.printf("Case #%d: ", i);
            go();
        }
    }

    private static void go(){
        int n = in.nextInt();
        int[] line = new int[5002];
        for (int i = 0; i < 2*n; i++){
            if (i % 2 == 0){
                line[in.nextInt()]++;
            }else{
                line[in.nextInt()+1]--;
            }
        }
        for (int i = 1; i < line.length; i++){
            line[i] += line[i-1];
        }
        int p = in.nextInt();
        for (int i = 0; i < p; i++){
            System.out.print(line[in.nextInt()]);
            if (i < p-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
