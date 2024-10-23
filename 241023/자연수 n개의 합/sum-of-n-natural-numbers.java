import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        simulate();
    }
    

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        int left = 1;
        int right = S;

        int result = Integer.MIN_VALUE;
        while(left<=right) {
            int mid = (left+right)/2;

            if(mid*(mid+1)/2 <=S) {
                left = mid+1; 
                result = Math.max(result,mid);               
            }else {
                right = mid-1;
            }
        }

        System.out.println(result);
    }
}