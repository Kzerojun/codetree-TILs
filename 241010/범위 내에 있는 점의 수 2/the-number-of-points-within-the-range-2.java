import java.util.*;
import java.io.*;

public class Main {
    static int N,Q;
    static int[] arr, prefix;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());       

        arr = new int[1_000_001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr[number] = 1;
        }

        prefix = new int[1_000_001];
        for(int i = 1 ; i<=1_000_000; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i = 0 ; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int result = prefix[end] - prefix[start-1];
            System.out.println(result);
        }
    }
}