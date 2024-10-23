import java.util.*;
import java.io.*;

public class Main {
    static int MAX_SIZE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        long left = 1;
        long right = MAX_SIZE;

        while(left<=right) {
            long mid = (left+right)/2;

            long result = cal(mid);
            if(result>=N) {
                right = mid-1;
            }else {
                left = mid+1;
            }
            
        }

        System.out.println(left);
    
    }

    private static int cal(int number) {
        int sum = 0;

        sum = sum + number/3;
        sum = sum + number/5;
        sum = sum - number/15;

        // 내가 몇번째 숫자인지
        return number-sum;
    }
}