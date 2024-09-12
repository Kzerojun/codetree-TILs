import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        cal();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void cal() {
        int sol = Integer.MIN_VALUE;

        for (int k = 0; k <= n + 1; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int result = bfs(i, j, k);
                    sol = Math.max(result, sol);
                }
            }
        }
        System.out.println(sol);
    }

    private static int bfs(int x, int y, int k) {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(x, y));
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;
        int goldCost = 0;

        while (!q.isEmpty()) {
            Location now = q.poll();

            if (graph[now.x][now.y] == 1) {
                goldCost += m;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (Math.abs(x - nx) + Math.abs(y - ny) > k) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Location(nx, ny));
            }
        }

        int cost = calCost(k);
        if (goldCost - cost > 0) {
            return goldCost / m;
        }

        return -1;
    }

    private static int calCost(int k) {
        return k * k + (k + 1) * (k + 1);
    }
}

class Location {
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}