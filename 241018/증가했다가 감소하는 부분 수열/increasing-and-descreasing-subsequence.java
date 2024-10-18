import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dpIncrease;
    static int[] dpDecrease;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dpIncrease = new int[N];
        dpDecrease = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dpIncrease[i] = -1;
            dpDecrease[i] = -1;
        }
    }

    private static void simulate() {
        dfsIncrease(0);
        dfsDecrease(N-1);

        int result = -1;
        for(int i= 0 ; i<N; i++) {
            int sum = dpDecrease[i] + dpIncrease[i];
            result = Math.max(sum,result);
        }

        System.out.println(result+1);
    }


    private static int dfsIncrease(int index) {
        if(index>=N) {
            return Integer.MIN_VALUE;
        }

        if(dpIncrease[index]!=-1) {
            return dpIncrease[index];
        }

        int notSelect = dfsIncrease(index+1);

        dpIncrease[index] = 1;

        for(int i = index+1; i<N; i++) {
            if(arr[i]>arr[index]) {
                int result = dfsIncrease(i);
                dpIncrease[index] = Math.max(dpIncrease[index],result+1);
            }
        }

        return dpIncrease[index] = Math.max(dpIncrease[index],notSelect);
    }

        private static int dfsDecrease(int index) {
        if(index<0) {
            return Integer.MIN_VALUE;
        }

        if(dpDecrease[index]!=-1) {
            return dpDecrease[index];
        }

        int notSelect = dfsDecrease(index-1);

        dpDecrease[index] = 1;

        for(int i = index-1; i>=0; i--) {
            if(arr[i]<arr[index]) {
                int result = dfsDecrease(i);
                dpDecrease[index] = Math.max(dpDecrease[index],result+1);
            }
        }

        return dpDecrease[index] = Math.max(dpDecrease[index],notSelect);
    }


}