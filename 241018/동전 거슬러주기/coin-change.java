import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dp = new int[M + 1];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.fill(dp, -1);
    }

    private static void simulate() {
        int result = dfs(M);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int dfs(int target) {
        if (target == 0) return 0;
        if (target < 0) return Integer.MAX_VALUE;
        if (dp[target] != -1) return dp[target];

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int subResult = dfs(target - arr[i]);
            if (subResult != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, subResult + 1);
            }
        }

        return dp[target] = minCoins;
    }
}