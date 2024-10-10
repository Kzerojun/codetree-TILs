import java.io.*;
import java.util.*;

public class Main {
    static int n,k;
    static int[] arr;
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
        
        arr = new int[n];

        for(int i = 0 ; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void simulate() {
        int count = 0;
        
        for(int i = n-1; i>=0; i--) {
            count += k /arr[i];
            k = k % arr[i];
        }

        System.out.println(count);
    }
}