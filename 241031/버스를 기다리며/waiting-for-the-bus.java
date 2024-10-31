import java.util.*;
import java.io.*;

public class Main {
    static int N,M,C;
    static int[] times;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        times = new int[N];
        for(int i =0 ; i<N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        
        int left = 0;
        int right = 1_000_000_000;

        while(left<=right) {
            int mid = (left+right)/2;

            if(isPossible(mid)) {
                right = mid-1;
            }else {
                left = mid +1;
            }

        }

        System.out.println(left+1);
    }

    private static boolean isPossible(int mid) {
        int bus = 1;

        int lastIndex = 0;

        for(int i = 0; i<N; i++) {
            if(times[i]-times[lastIndex]>mid) {
                bus++;
                lastIndex = i;
            }
        }

        return bus<=M;
    }
}