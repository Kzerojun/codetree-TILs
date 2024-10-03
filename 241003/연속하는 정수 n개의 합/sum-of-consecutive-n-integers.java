import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void simulate() {
        int sum = 0;
        int i = 0;
        int result = 0;
        for(int j = 1; j<=n; j++) {
            while(i+1<=n && arr[i+1]+sum<=m) {
                i++;
                sum += arr[i];
                
            }

            if(sum==m) {
                result++;
            }

            sum -= arr[j];
        }

        System.out.println(result);
    }
}