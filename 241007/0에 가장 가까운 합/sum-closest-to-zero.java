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

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    private static void simulate() {
        int i = n;
        int sum = Integer.MAX_VALUE;

        for(int j =0; j<n; j++) {
            while(i-1>=0 && Math.abs(arr[i-1]+arr[j])<sum) {
                i--;
                
                if(i>j) {
                    sum = Math.min(Math.abs(arr[i]+arr[j]),sum);
                }
            }
        }

        System.out.println(sum);
    
    }
}