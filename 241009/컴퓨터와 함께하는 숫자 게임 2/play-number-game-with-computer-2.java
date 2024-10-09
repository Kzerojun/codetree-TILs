import java.util.*;
import java.io.*;

public class Main {
    static long m;
    static long a,b;
    static long minResult = Long.MAX_VALUE;
    static long maxResult = Long.MIN_VALUE;
    
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
    }

    private static void simulate() {
        for(long i = a; i<=b; i++) {
            long count = find(i);
            minResult = Math.min(minResult,count);
            maxResult = Math.max(maxResult,count);
        }

        System.out.println(minResult +" "+maxResult);
    }

    private static int find(long target) {
        long left = 1;
        long right = m;
        int count = 0;
        while(left<=right) {
            count++;
            long mid = (left+right)/2;
            if(mid > target) {
                right = mid -1;
            }else if (mid<target) {
                left = mid+1;
            }else {
                return count;
            }
            
        }
        return -1;

    }



}