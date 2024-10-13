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
        dp = new int[N][N];

        for(int i = 0 ; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j= 0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<N; i++) {
            Arrays.fill(dp[i],-1);
        }
    }

    private static void simulate() {
        int result = dfs(0,N-1);
        System.out.println(result);
    }

    private static int dfs(int i , int j) {
        if(i>=N || j<0) {
            return Integer.MAX_VALUE;
        }

        if(i == N-1 && j== 0) {
            return graph[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }


        int down = dfs(i+1,j);
        int left = dfs(i,j-1);

        return dp[i][j] = graph[i][j] + Math.min(down,left);

    }
}