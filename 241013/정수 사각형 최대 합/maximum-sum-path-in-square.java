import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.

        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for(int i = 0 ; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j= 0 ; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];

        for(int i = 0 ; i<N; i++) {
            Arrays.fill(dp[i],-1);
        }

        
    }

    private static void simulate() {
        int result = -1;
        for(int j = 0 ; j<N; j++) {
            result = Math.max(dfs(0,j),result);
        }

        System.out.println(result);
    }

    private static int dfs(int i, int j) {
        if(i >= N  || j>=N) {
            return Integer.MIN_VALUE;
        }

        if(i == N-1 && j == N-1) {
            return graph[i][j];
        }

       

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int straight = dfs(i+1,j);
        int right = dfs(i,j+1);

        return dp[i][j] = graph[i][j] + Math.max(straight,right);
    }
}