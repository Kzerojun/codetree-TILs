import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dp;
    static int[] coins;
    static final int MAX_VALUE = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M + 1];
        coins = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, -1);

        int result = dfs(M);
        System.out.println(result >= MAX_VALUE ? -1 : result);
    }

    private static int dfs(int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return MAX_VALUE;
        if (dp[amount] != -1) return dp[amount];

        dp[amount] = MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int result = dfs(amount - coins[i]);
            dp[amount] = Math.min(dp[amount], result + 1);
        }

        return dp[amount];
    }
}