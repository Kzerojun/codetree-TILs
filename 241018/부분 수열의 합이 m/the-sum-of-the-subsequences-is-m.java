import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[][] dp;
    static final int INF = 10_001;

    public static void main(String[] args) throws IOException {
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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<=100; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = dfs(0,M);
        System.out.println(result == INF ? -1 : result);
        
    }


    private static int dfs(int index, int target) {
        if(target == 0) {
            return 0;
        }

        if(target<0) {
            return INF;
        }

        if(dp[index][target]!=-1) {
            return dp[index][target];
        }

        dp[index][target] = INF;
        for(int i = index; i<N; i++) {
            if(target - arr[i] >=0) {
                int result = dfs(i+1,target-arr[i]);
                dp[index][target] = Math.min(dp[index][target],result+1);
            }
        }

        return dp[index][target];
    }
   
}