import java.util.*;
import java.io.*;


public class Main {
    private static int n,k;
    private static int[][] arr;
    private static int[][] prefix;

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

        arr = new int[n+1][n+1];

        for(int i = 1 ; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prefix = new int[n+1][n+1];
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] -prefix[i-1][j-1] + arr[i][j];
            }
        }


    }

    private static void simulate() {
        int result = Integer.MIN_VALUE;
        for(int i = 1; i<=n - k +1; i++) {
            for(int j = 1; j<=n - k +1; j++) {
                result = Math.max(result,prefix[i][j]-prefix[i-1][j]-prefix[i][j-1]-prefix[i-1][j-1]);
            }
        }

        System.out.println(result);
    }
}