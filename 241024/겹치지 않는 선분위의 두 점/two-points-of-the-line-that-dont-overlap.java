import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static final long MAX_LEN = (long)1e18;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        

        Line[] lines = new Line[M];
        for(int i =0 ; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[i] = new Line(a,b);    
        }

        Arrays.sort(lines,(o1,o2)->{
            return o1.a - o2.a;
        });

        long left = 1;
        long right = MAX_LEN;

        while(left<=right) {
            long mid = (left + right) / 2;

            
            if(isPossible(mid,lines)) {
                left = mid+1;
            }else {
                right = mid-1;
            }

        }

        System.out.println(left-1);



    }

    private static boolean isPossible(long dist,Line[] lines) {
        long cnt = 0;
        long lastIndex = -MAX_LEN;

        for(int i =0 ; i<M; i++) {
            long a = lines[i].a;
            long b = lines[i].b;

            while(lastIndex + dist <=b) {
                cnt++;
                lastIndex = Math.max(a,lastIndex+dist);
            }

        }

        return cnt >= N;
    }
}

class Line{
    int a;
    int b;


    Line(int a, int b) {
        this.a = a;
        this.b = b;
    }
}