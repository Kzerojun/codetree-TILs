import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
        System.out.println(getMaxLIS());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }
    }

    private static void simulate() {
        for(int i = 0; i < N; i++) {
            if(dp[i] == -1) {
                dfs(i);
            }
        }
    }

    private static int dfs(int index) {
        if(dp[index] != -1) {
            return dp[index];
        }

        dp[index] = 1; // 자기 자신만으로 이루어진 부분 수열의 길이는 1

        for(int next = index + 1; next < N; next++) {
            if(arr[next] > arr[index]) {
                dp[index] = Math.max(dp[index], 1 + dfs(next));
            }
        }

        return dp[index];
    }

    private static int getMaxLIS() {
        int maxLength = 0;
        for(int length : dp) {
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}