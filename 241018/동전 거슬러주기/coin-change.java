import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] dp;

    
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
        
        dp = new int[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 101;
        }
    }

    private static void simulate() {
        for(int i = 0 ; i<N; i++) {
            dfs(i,0);
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i<N; i++) {
            System.out.println(dp[i]);
        }

        if(result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    private static int dfs(int index, int sum) {
        if(sum== M) {
            return 1;
        }

        if(sum>M) {
            return 101;
        }

        if(dp[index]!= 101) {
            return dp[index];
        }

        for(int i = index; i<N; i++) {
            int result = dfs(i,sum+arr[i])+1;
            dp[index] = Math.min(result,dp[index]);
        }

        return dp[index];
    }
}