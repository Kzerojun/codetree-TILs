import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] arr;
    static int[][] dp;
    static int INF = 10_001;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[101][10_001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i<=100; i++) {
            Arrays.fill(dp[i],-1);
        }

        int result = dfs(0,M);
        if(result != INF) {
            System.out.print("No");
        }else {
            System.out.print("Yes");
        }
    }

    private static int dfs(int index, int target) {
        if(target == 0 ) {
            return 0;
        }

        if(target<0) {
            return INF;
        }

        dp[index][target] = INF;
        for(int i = index+1; i<N; i++) {
            if(target-arr[index]>=0) {
                int result = dfs(i,target-arr[index]);
                dp[index][target] = Math.min(result+1,dp[index][target]);
            }
        }

        return dp[index][target];
    }
}