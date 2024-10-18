import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Work[] works;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        works = new Work[N];
        dp = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            dp[i] = -1;
            works[i] = new Work(s, e, p);
        }
    }

    private static void simulate() {
        int result = 0;

        for(int i = 0; i < N; i++) {
            result = Math.max(result, dfs(i));
        }
        System.out.println(result);
    }

    private static int dfs(int index) {
        if(dp[index] != -1) {
            return dp[index];
        }

        dp[index] = works[index].p; // 현재 작업의 점수

        for(int i = index + 1; i < N; i++) {
            if(works[index].e < works[i].s) {
                dp[index] = Math.max(dp[index], works[index].p + dfs(i)); // 다음 작업의 점수 추가
            }
        }

        return dp[index];
    }
}

class Work {
    int s;
    int e;
    int p;

    Work(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }
}