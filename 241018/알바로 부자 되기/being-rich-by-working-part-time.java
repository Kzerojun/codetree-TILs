import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Work[] works;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        works = new Work[N];
        dp = new int[N];

        for(int i = 0 ; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            dp[i] = -1;
            works[i] = new Work(s,e,p);
        }
    }

    private static void simulate() {
        for(int i = 0 ; i<N; i++) {
            if(dp[i]==-1) {
                dfs(i);
            }
        }
        int result = -1;

        for(int i =0  ; i<N; i++) {
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);
    }

    private static int dfs(int index) {
        if(dp[index]!= -1) {
            return dp[index];
        }

        dp[index] = works[index].p;

        for(int i = index+1; i<N; i++) {
            if(works[index].e < works[i].s) {
                int result = dfs(index);
                dp[index] = Math.max(result+dp[index],dp[index]);
            }
        }

        return dp[index];
    }
}

class Work{
    int s;
    int e;
    int p;

    Work(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }
}