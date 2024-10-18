import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new boolean[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        boolean result = dfs(0, M);
        System.out.println(result ? "Yes" : "No");
    }

    private static boolean dfs(int index, int target) {
        if (target == 0) {
            return true;
        }

        if (index >= N || target < 0) {
            return false;
        }

        if (dp[index][target]) {
            return true;
        }

        for (int i = index; i < N; i++) {
            if (target - arr[i] >= 0) {
                if (dfs(i + 1, target - arr[i])) {
                    dp[index][target] = true;
                    return true;
                }
            }
        }

        
        return dp[index][target] = false;
    }
}