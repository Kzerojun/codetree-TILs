import java.util.*;
import java.io.*;

public class Main {
    static int n,t;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        graph = new int[3][n];

        for(int i = 0 ; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j= 0 ; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    private static void simulate() {
        for(int i = 0 ; i<t; i++) {
            rotate();
        }


        for(int i = 0 ; i<3; i++) {
            for(int j = 0 ; j<n; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotate() {
        int tmp = graph[2][n-1];

        for(int i = 2; i>=0; i--) {
            for(int j = n-1; j>=1; j--) {
                graph[i][j] = graph[i][j-1];
            }

            if(i>0) {
                graph[i][0] = graph[i-1][n-1];
            }
        }

        graph[0][0] = tmp;
    }
}