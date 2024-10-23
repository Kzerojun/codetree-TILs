import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        simulate();
    }

    private static void simulate() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());

        long left = 1;
        long right= n*n;

        while(left <= right) {
            long mid = (left+right)/2;

            long result = cal(mid,n);
            if(result>=k) { //결정 문제에 대한 답이 YES 라면 왼쪽에 조건을 만족하는 숫자가 더 있을 가능이 있을수도있따.
                right = mid -1;
            }else {
                left = mid+1;
            }
        }

        System.out.println(left);
    }

    private static long cal(long number,long n) {
        
        long count = 0;

        for(int i = 1; i<=n; i++) {
            count += Math.min(n,number/i);
        }

        return count;
    }
}