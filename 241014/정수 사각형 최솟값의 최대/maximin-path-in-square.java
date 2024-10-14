import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        System.out.println(dfs(0,0));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        dp= new int[N][N];

        for(int i = 0 ; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j <N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
    }

    private static int dfs(int i , int j ) {
        if(i == N-1 && j == N-1) {
            return graph[i][j];
        }

        if(i >=N || j>=N) {
            return -1_000_001;
        }

        if(dp[i][j]!= -1) {
            return dp[i][j];
        }

        int down = dfs(i+1,j);
        int right = dfs(i,j+1);

        int maxOfMin = Math.max(down,right);

        return dp[i][j] = Math.min(graph[i][j],maxOfMin);
    }
}