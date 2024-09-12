import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] graph;
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        start();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MIN_VALUE;
    }

    private static void start() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, 0, i, j, 0);
            }
        }
        System.out.println(result);
    }

    private static void dfs(int x, int y, int sum, int originX, int originY, int direction) {
        if (direction != 0) {
            if (x == originX && y == originY) {
                result = Math.max(result, sum);
                return;
            }
            
        }

  
        if (direction >= 4) {
            return;
        }

        int nx = x + dx[direction];
        int ny = y + dy[direction];

        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
            dfs(nx, ny, sum + graph[nx][ny], originX, originY, direction);
        }

        dfs(x, y, sum, originX, originY, direction + 1);
    }
}