import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1 ; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,1,n+1);
    }

    private static void simulate() {
        int i = n;
        int sum = Integer.MAX_VALUE;

        for(int j =1; j<=n; j++) {
           if(j<i) {
                sum = Math.min(sum,Math.abs(arr[i]+arr[j]));
           }

           while(i-1>j && arr[i] + arr[j] >0) {
            i--;
            sum = Math.min(sum,Math.abs(arr[i]+arr[j]));
           }

            
        }

        System.out.println(sum);
    
    }
}