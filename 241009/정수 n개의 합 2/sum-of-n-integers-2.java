import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    static int[] arr;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        prefixSum = new int[n+1];
        for(int i =  1; i<=n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
    }

    private static void simulate() {
        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= n - k + 1; i++) {
            result = Math.max(result, prefixSum[i+k-1] - prefixSum[i-1]);
        }
            


        System.out.println(result);
    }
}