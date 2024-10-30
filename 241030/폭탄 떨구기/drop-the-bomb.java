import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int[] locations;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        locations = new int[N];

        for(int i = 0 ; i<N; i++) {
            locations[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(locations);

        int left = 0;
        int right = 1_000_000_000;

        while(left<=right) {
            int mid = (left+right)/2;

            if(isPossible(mid)) {
                right = mid -1;
            }else {
                left = mid + 1;
            }
        
        }

        System.out.println(left);

        

    }

    private static boolean isPossible(int mid) {
        int cnt = 1;
        int index = 0;

        for(int i =0 ; i<N; i++) {
            if(locations[i]-locations[index]>mid*2) {
                cnt++;
                index = i;
            }
        }

        if(cnt>K) {
            return false;
        }

        return true;
    }
}