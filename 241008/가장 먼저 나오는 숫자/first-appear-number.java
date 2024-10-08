import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int[] problems;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        problems = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void simulate() {
        for(int i =0 ; i<m; i++) {
            int result = find(problems[i]);
            if(problems[i]!= arr[result]) {
                System.out.println(-1);
            }else {
                System.out.println(result+1);
            }
        }
    }

    private static int find(int number) {
        int left = 0 ;
        int right = n-1;

        while(left<=right) {
            int mid = (left + right) /2;

            if(arr[mid]>=number) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return left;
    }
}