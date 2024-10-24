import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int MAX_LEN = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        

        int[] times = new int[m];

        for(int i = 0 ; i<m; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = MAX_LEN;


        while(left<=right) {
            int mid = (left+right)/2;

            if(isCanPass(mid,times)) {
                right = mid-1;
            }else {
                left = mid+1;
            }
            
        }

        System.out.println(left);
    }

    private static boolean isCanPass(int time,int[] arr) {
        int cnt = 0 ;

        for(int use : arr) {
            cnt = cnt + time/use;

            if(cnt>=n) {
                return true;
            }
        }

        return false;
    }
}