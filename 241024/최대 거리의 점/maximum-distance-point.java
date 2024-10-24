import java.util.*;
import java.io.*;

public class Main {
    static int MAX_LEN = 1_000_000_000;
    
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        
        int left = 0;
        int right = MAX_LEN;

        while(left<=right) {
            int mid = (left + right) / 2;

            if(!isPossible(mid,arr,n,m)) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        System.out.println(left-1);
    }

    public static boolean isPossible(int length,int[] arr,int n,int m) {
        int cnt = 1;
        int lastIdx = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] - arr[lastIdx] >= length) {
                cnt++;
                lastIdx = i;
            }
        }
        return cnt >= m;
    }
}