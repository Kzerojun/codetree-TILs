import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] dp;
    static final int INF = 10_001;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[M + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, -1);
    }

    private static void simulate() {
       for(int i =0  ;i<N; i++) {
        dfs(M,i);
       }
       int result = dp[M];
       System.out.println(result == INF ? -1 : result);
    }

    private static int dfs(int target, int index) {
        if (target == 0) {
            return 0;  // 수열의 길이를 반환하므로 0으로 변경
        }

        if (target < 0 || index >= N) {
            return INF;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        dp[target] = INF;
        for (int i = index; i < N; i++) {
            int result = dfs(target - arr[i], i + 1);
            dp[target] = Math.min(result + 1, dp[target]);
        }

        return dp[target];
    }
}