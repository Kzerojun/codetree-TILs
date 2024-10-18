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
            dp[i] = -1;
        }
    }

    private static void simulate() {
        for(int i = 0 ; i<N; i++) {
            dfs(i,0,0);
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i<N; i++) {
            if(dp[i]!=0) {
                result = Math.min(result,dp[i]);
            }
            System.out.println(dp[i]);
        }

        if(result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    private static int dfs(int index, int sum, int count) {
        if(sum== M) {
            return dp[index] = count;
        }

        if(sum>M) {
            return 101;
        }

        if(dp[index]!= -1) {
            return dp[index];
        }

        dp[index] = 0;

        for(int i = index; i<N; i++) {
            int result = dfs(i,sum+arr[i], count+1);

            dp[index] = Math.min(result+1,dp[index]);
        }

        return dp[index];
    }
}