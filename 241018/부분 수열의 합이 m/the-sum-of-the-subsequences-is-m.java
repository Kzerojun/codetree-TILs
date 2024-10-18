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
        simulate();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        

        arr = new int[N];
        dp = new int[M+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i= 0 ; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i<=M; i++) {
            dp[i] = -1;
        }
    }

    private static void simulate() {
       int result = dfs(M,0);
       if(result == INF) {
        System.out.println(-1);
       }else {
        System.out.println(result);
       }
    }

    private static int dfs(int target, int index) {
        if(target == 0) {
            return 1;
        }

        if(target<0) {
            return INF;
        }

        if(dp[target]!= -1) {
            return dp[target];
        }

        dp[target] = INF;
        for(int i = index; i<N; i++) {
            int result = dfs(target-arr[i],i+1);
            dp[target] = Math.min(result+1,dp[target]);
        }

        return dp[target];
    }


}