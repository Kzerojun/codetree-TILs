import java.util.*;
import java.io.*;

public class Main {
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void simulate() {
        int j = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            while (j + 1 <= n && sum < s) {
                j++;
                sum += arr[j];
            }

            if (sum >= s) {
                result = Math.min(result, j - i + 1);
            }

            sum -= arr[i];
        }

        // 결과 출력. 합이 s 이상인 경우만 출력
        if (result == Integer.MAX_VALUE) {
            System.out.println(0); // 합이 s 이상인 부분 배열이 없음을 나타냄
        } else {
            System.out.println(result);
        }
    }
}