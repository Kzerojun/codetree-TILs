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
        for(int i = 0 ; i<N; i++) {
            dfs(0,0,i);
        }
        int result = Integer.MAX_VALUE;

        for(int i = 0 ; i<N; i++) {
            result = Math.min(result,dp[i]);
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int dfs(int sum, int count, int index) {
        if (sum == M) return count;
        if (sum > M) return Integer.MAX_VALUE;
        if (dp[sum] != -1) return dp[sum];

        int minCoins = Integer.MAX_VALUE;
        for (int i = index; i < N; i++) {
            int newSum = sum + arr[i];
            if (newSum <= M) {
                int subResult = dfs(newSum, count + 1,i);
                if (subResult != Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, subResult);
                }
            }
        }

        return dp[index] = minCoins;
    }
}