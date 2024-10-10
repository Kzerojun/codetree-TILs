import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        init();
        int result = fibo(n);
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        for(int i = 0 ; i<=n; i++) {
            dp[i] = -1;
        }


    }

    private static int fibo(int number) {
        if(number<=2) {
            return 1;
        } 

        if(dp[number]!= -1) {
            return dp[number];
        }

        int left = fibo(number-1);
        int right = fibo(number-2);

        return dp[number] = left+right;
    }
}