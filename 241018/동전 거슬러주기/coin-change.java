import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] dp;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M];   
        coins = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0 ; i<M; i++) {
            dp[i] = 10_000_001;
        }
    }

    private static void simulate() {
        for(int i = 0; i<N; i++) {
            dfs(i);
        }

        int result = Integer.MAX_VALUE;

        for(int i =0  ;i<N; i++) {
            result = Math.min(result,dp[i]);
        }

        System.out.println(result);
    }

    private static int dfs(int sum) {
        if(sum == M) {
            return 0;
        }

        if(sum> M) {
            return 10_000_001;
        }

        if(dp[sum]!=10_000_001) {
            return dp[sum];
        }

        dp[sum] = 10_000_001;

        for(int i = 0 ; i<N;i++) {
            if(sum<=M) {
                int result = dfs(sum+coins[i]);
                dp[sum] = Math.min(result+1,dp[sum]);
            }
        }

        return dp[sum];
    }
}