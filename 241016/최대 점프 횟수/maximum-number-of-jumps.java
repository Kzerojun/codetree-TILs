import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }
    }

    private static void simulate() {
        dfs(0);
        System.out.println(dp[0]);
    }

    private static int dfs(int now) {
        if(dp[now]!=-1) {
            return dp[now];
        }
        
        dp[now] = 0;

        for(int weight = 0; weight<arr[now]; weight++) {
            int next = weight + now;

            int result = 0;
            if(next<n) {
                result = dfs(next);
            }
            
            dp[now] = Math.max(result+1,dp[now]);
        }

        return dp[now];
    }

}