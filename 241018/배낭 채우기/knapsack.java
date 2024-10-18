import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static Jewel[] jewels;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jewels = new Jewel[N];
        
        for(int i = 0 ; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            
            jewels[i] = new Jewel(W,V);
        }

        dp = new int[N][M+1];

        for(int i = 0; i<N; i++) {
            Arrays.fill(dp[i],-1);
        }

        System.out.println(dfs(0,M));
    }

    private static int dfs(int index, int target) {
        if(target == 0) {
            return 0;
        }
        
        if(index >= N || target<0) {
            return Integer.MIN_VALUE;
        }

        if(dp[index][target]!=-1) {
            return dp[index][target];
        }

        dp[index][target] = 0;
        
        for(int i = index; i<N; i++) {
            if(target - jewels[i].W >=0) {
                int result = dfs(i+1,target-jewels[i].W);
                dp[index][target] = Math.max(dp[index][target],result+jewels[i].V);
            }
        }

        return dp[index][target];
    }

    
    
}
class Jewel{
    int W;
    int V;

    Jewel(int W,int V) {
        this.W = W;
        this.V = V;
    }    
}