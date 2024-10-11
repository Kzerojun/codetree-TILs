import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[1001];
        for(int i = 0; i<=1000; i++) {
            dp[i] = -1;
        }
    }

    private static void simulate() {
        int result = up(0) % 10_007 ;
        System.out.println(result);
    }

    private static int up(int number) {
        if(number>n) {
            return 0;
        }

        if(number == n) {
            return 1;
        }

        if(dp[number]!= -1) {
            return dp[number] ;
        }


        int two = up(number+2) % 10_007;
        int three = up(number+3) % 10_007;

        return dp[number] = two+three % 10_007;
    }
}