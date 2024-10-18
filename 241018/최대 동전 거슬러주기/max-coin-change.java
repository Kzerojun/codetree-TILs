import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] dp;
    static int INF = 10_001;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i<=M; i++) {
            dp[i] = -1;
        }

        int result = dfs(M);
        if(result == INF) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    private static int dfs(int target) {
        if(target == 0) {
            return 0;
        }

        if(target<0) {
            return -100000;
        }

        if(dp[target]!=-1) {
            return dp[target];
        }
        
        dp[target] = -100000;
        
        for(int i = 0 ; i<N; i++) {
            if(target-arr[i]>=0) {
                int result = dfs(target-arr[i]);
                dp[target] = Math.max(dp[target],result+1);
            }
        }

        return dp[target];
    }
}