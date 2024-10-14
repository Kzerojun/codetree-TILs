import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int N;
    static int[][] graph;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
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
            for(int j =0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
    }

    private static void simulate() {
        int result = -1;
        for(int i =0; i<N; i++) {
            for(int j =0; j<N; j++) {
                result = Math.max(dfs(i,j),result);
            }
        }

        System.out.println(result);
    }

    private static int dfs(int i , int j) {
        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        
        dp[i][j] = 1;

        for(int k = 0 ; k<4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx<0 || ny<0 || nx>=N || ny>=N || graph[nx][ny]<=graph[i][j]) continue;

            dp[i][j] = Math.max(dp[i][j],dfs(nx,ny)+1);
        }

        return dp[i][j];
    } 
}