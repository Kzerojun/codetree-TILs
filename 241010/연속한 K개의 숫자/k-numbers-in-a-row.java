import java.util.*;
import java.io.*;

public class Main {
    static int N,K,B;
    static int[] arr, prefix;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];



        for(int i =0 ; i<B; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[number] = 1;
        }

        prefix = new int[N+1];
        for(int i = 1; i<=N; i++) {
            prefix[i] = prefix[i-1] +arr[i];
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 1; i<=N-K+1; i++)  {
            result = Math.min(prefix[i+K-1]-prefix[i-1],result);
        }

        System.out.println(result);

    }
}