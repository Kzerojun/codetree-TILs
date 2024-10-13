import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int n;

    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] =1;
        dp[2] = 3;
    }

    private static void simulate() {
        if(n>=3) {
            for(int i = 3; i<=n; i++) {
                dp[i] = (dp[i-1] + 2* dp[i-2]) % 10_007;
            }
        }

        System.out.println(dp[n]%10_007);
    }
}