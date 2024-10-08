import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void simulate() {
        int sum = 0;
        int result = Integer.MIN_VALUE;

        for(int i = 1; i<=n; i++) {
            

            if(sum < 0 ) {
                sum = arr[i] ;
            }else {
                sum = sum + arr[i];
            }
            result = Math.max(result,sum);
        }

        System.out.println(result);
    }
}