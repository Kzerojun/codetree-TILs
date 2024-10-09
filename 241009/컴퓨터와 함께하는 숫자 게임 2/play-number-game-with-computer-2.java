import java.util.*;
import java.io.*;

public class Main {
    static int m;
    static int a,b;
    static int minResult = Integer.MAX_VALUE;
    static int maxResult = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    private static void simulate() {
        for(int i = a; i<=b; i++) {
            int count = find(i);
            minResult = Math.min(minResult,count);
            maxResult = Math.max(maxResult,count);
        }

        System.out.println(minResult +" "+maxResult);
    }

    private static int find(int target) {
        int left = 1;
        int right = m;
        int count = 0;
        while(left<=right) {
            count++;
            int mid = (left+right)/2;
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