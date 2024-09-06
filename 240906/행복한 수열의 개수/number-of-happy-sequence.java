import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] graph;
    static int result;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        start();
        System.out.println(result);
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][n];

        for(int i =0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0 ;
    }

    private static void start() {
        for(int i = 0 ; i<n; i++) {
            Stack<Integer> row = new Stack<>();
            Stack<Integer> col = new Stack<>();
            boolean rowCheck = false;
            boolean colCheck = false;

            for(int j = 0; j<n; j++) {
                int rowNumber = graph[i][j];
                int colNumber = graph[j][i];

                if(row.isEmpty()) {
                    row.push(rowNumber);
                }else {
                    if(row.peek() == rowNumber) {
                        row.push(rowNumber);
                    }else {
                        while(!row.isEmpty()) {
                            row.pop();
                        }
                        row.push(rowNumber);
                    }
                }

                if(col.isEmpty()) {
                    col.push(colNumber);
                }else {
                    if(col.peek() == colNumber) {
                        col.push(colNumber);
                    }else {
                        while(!col.isEmpty()) {
                            col.pop();
                        }
                        col.push(colNumber);
                    }
                }
                if(row.size()>=m) {
                    rowCheck = true;
                }

                if(col.size()>=m) {
                    colCheck = true;
                }

            }

            if(rowCheck) {
                result++;
            }
            if(colCheck) {
                result++;
            }

        }
    }
}