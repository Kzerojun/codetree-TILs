import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] arr;
    static Info[] infos;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        infos = new Info[m];

        for(int i =0 ; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            infos[i] = new Info(start,end);
        }
    }

    private static void simulate() {
        for(int i = 0 ; i<m; i++) {

            int result = upperFind(infos[i].end) - lowerFind(infos[i].start);
            System.out.println(result);
        }
    }

    private static int upperFind(int number) {
        int left = 0;
        int right = n-1;

        while(left<=right) {
            int mid = (left + right) / 2;

            if(arr[mid]>number) {
                right = mid-1;
            }else {
                left = mid +1;
            }
        }

        return left;
    }

    private static int lowerFind(int number) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= number) {
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        return left;
    }

    
}

class Info{
    int start;
    int end;

    Info(int start, int end) {
        this.start = start;
        this.end = end;
    }
}