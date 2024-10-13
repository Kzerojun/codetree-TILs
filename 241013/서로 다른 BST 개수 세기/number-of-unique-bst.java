import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][]dp;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        int result = dfs(1,n);
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];

        for(int i = 0 ; i<=n; i++) {
            Arrays.fill(dp[i],-1);
        }
    }

    private static int dfs(int start, int end) {
        if(start>=end) {
            return 1;
        }

        if(dp[start][end]!=-1 ) {
            return dp[start][end];
        }
        
        int result = 0;
        for(int root = start; root<=end; root++) {
            int left = dfs(start,root-1);
            int right = dfs(root+1,end);

            result = result + left * right;
        }

        return dp[start][end] = result;
    }

    


}