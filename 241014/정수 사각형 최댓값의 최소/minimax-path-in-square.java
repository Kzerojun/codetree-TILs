import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        System.out.println(dfs(0,0));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        dp = new int[N][N];
        

        for(int i = 0 ; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++) {
                dp[i][j] = -1;
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int dfs(int i, int j) {
        if(i == N-1 && j == N-1) {
            return graph[i][j];
        }

        if(i>=N || j>= N) {
            return Integer.MIN_VALUE;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int right = dfs(i,j+1);
        int down = dfs(i+1,j);
        int tmp = Math.min(right,down);

        return dp[i][j] = Math.max(graph[i][j],tmp);
    }
}