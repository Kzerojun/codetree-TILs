import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        dp = new int[n][m];

        for(int i = 0 ; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
    }

    private static void simulate() {
        dfs(0,0);
        System.out.println(dp[0][0]);
    }

    private static int dfs(int i, int j) {
        if(dp[i][j] !=-1) {
            return dp[i][j];
        }

        dp[i][j] = 1;

        for(int x = i+1; x<n; x++) {
            for(int y = j+1; y<m; y++) {
                if(graph[i][j]<graph[x][y]) {
                    int result = dfs(x,y);
                    dp[i][j] = Math.max(dp[i][j],result+1);
                }
            }
        }

        return dp[i][j];
    }
}