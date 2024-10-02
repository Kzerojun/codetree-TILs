import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void simulate() {
        Map<Integer,Integer> map = new HashMap<>();

        int j = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++) {
            while(j+1 <=n && map.getOrDefault(arr[j+1],0)+1<=1) {
                map.put(arr[j+1],map.getOrDefault(arr[j+1],0)+1);
                j++;
            }

            result  = Math.max(result,j-i+1);
            map.put(arr[i],map.getOrDefault(arr[i],0)-1);
        }

        System.out.println(result);
    }
}