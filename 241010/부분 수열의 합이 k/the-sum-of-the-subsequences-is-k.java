import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    static int[] arr;
    static int[] prefix;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        prefix = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        int result = 0;
        for(int i = 1; i<=n; i++) {
            for(int j =  i; j<=n; j++) {
                if(prefix[j]-prefix[i-1]==k) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    
}