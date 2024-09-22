import java.util.*;
import java.io.*;

public class Main {
    static int n,t;
    static int[][] graph;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());


        graph = new int[2][n];

        for(int i =0; i< 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0  ; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int j = n-1  ; j>=0; j--) {
            graph[1][j] = Integer.parseInt(st.nextToken());
        }

    }

    private static void simulate() {
        for(int i= 0 ;i <t; i++) {
            rotate();
        }

        for(int i =0; i< 1; i++) {
            for(int j =0  ; j<n; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

        for(int j =n-1  ; j>=0; j--) {
                System.out.print(graph[1][j]+" ");
            }
        System.out.println();
    }

    private static void rotate() {
        int tmp = graph[0][n-1];

        for(int i = n-1 ;i>=1; i--) {
            graph[0][i] = graph[0][i-1];
        }
        graph[0][0] = graph[1][0];
        
        for(int i = 0 ; i<n-1; i++) {
            graph[1][i] = graph[1][i+1];
        }
        graph[1][n-1] = tmp;
    }
}