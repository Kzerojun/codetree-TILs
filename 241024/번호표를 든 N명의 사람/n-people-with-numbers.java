import java.util.*;
import java.io.*;

public class Main {
    static int N,Tmax;
    static int[] times;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Tmax = Integer.parseInt(st.nextToken());
        
        times = new int[N];

        for(int i = 0 ; i<N; i++) {
            int time = Integer.parseInt(br.readLine());
            times[i] = time;
        }

        int left = 1;
        int right = N;

        while(left<=right) {
            int mid = (left+right)/2;

            if(isPossible(times,mid)) {
                right = mid-1;
            }else {
                left = mid+1;
            }
            
        }

        System.out.println(left);
    }

    private static boolean isPossible(int[]times, int mid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i =0; i<mid; i++) {
            pq.add(times[i]);
        }

        for(int i = mid; i<N; i++) {
            int curTime = pq.poll();
            pq.add(curTime+times[i]);
        }

        int endTime = 0;
        while(!pq.isEmpty()) {
            endTime =Math.max(endTime,pq.poll());
        }

        return endTime <= Tmax;
    }
}