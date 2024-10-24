import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,1,-1};
    static int goal;


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        
        if(N*N%2==1){
            goal = N*N/2+1;
        }else {
            goal = N*N/2;
        }

        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0 ;j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int left = 0;
        int right = 1_000_000;


        while(left<=right) {
            int mid = (left+right)/2;

            if(isPossible(mid)) {
                right = mid-1;
            }else {
                left = mid +1;
            }
        }

        System.out.println(left);
        
    }

    private static boolean isPossible(int mid) {
        int cnt = 0;

        for(int i =0  ; i<N; i++) {
            for(int j =0 ; j<N; j++) {
                if(graph[i][j] <= mid) {
                    cnt++;
                }
            }
        }


        if(cnt >=goal) {
            return true;
        }

        return false;
    }

  
}


class Location {
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y =y;
    }
}