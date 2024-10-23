import java.util.*;
import java.io.*;

public class Main {
    static int MAX_NUM = 100_000;
    
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        

        List<Integer> numbers = new ArrayList<>();

        for(int i = 0 ; i<n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }


        int left = 1;
        int right = MAX_NUM;

        int result = 0;
        while(left<=right) {
            int mid = (left+right)/2;

            if(isPossible(mid,numbers,m)) {
                result = Math.max(result,mid);
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        System.out.println(result);

    }

    private static boolean isPossible(int mid, List<Integer> numbers, int m) {
        int cnt = 0;

        for(int number : numbers) {
            int count = number / mid;
            cnt+= count;
        }

        if(cnt>=m) {
            return true;
        }

        return false;
    }
}