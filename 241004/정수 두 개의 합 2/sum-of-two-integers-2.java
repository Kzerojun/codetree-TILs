import java.util.*;
import java.io.*;

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
        
        arr = new int[n+1];

        for(int i = 1 ;i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void simulate() {
        Arrays.sort(arr,1,n+1);

        int result = 0;

        int j = n;

        for(int i = 1; i<=n; i++) {
            while(j!=1 && arr[i]+arr[j]>k) {
                j--;
            }

            if(j<=i){
                break;
            }

            result += j-i;
        }

        System.out.println(result);
    }
}