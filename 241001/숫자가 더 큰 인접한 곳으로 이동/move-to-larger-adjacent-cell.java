import java.io.*;
import java.util.*;

public class Main {
    static int n, r, c;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};  // 상, 하, 좌, 우

    public static void main(String[] args) throws IOException {
        init();
        move();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;  // 0-indexed
        c = Integer.parseInt(st.nextToken()) - 1;  // 0-indexed

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void move() {
        StringBuilder sb = new StringBuilder();
        int x = r, y = c;
        sb.append(graph[x][y]).append(" ");  // 시작 위치 숫자 출력

        while (true) {
            int nextX = -1, nextY = -1;
            int maxValue = graph[x][y];

            // 상하좌우 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 격자 범위를 벗어나지 않고, 현재 위치보다 큰 값이 있을 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && graph[nx][ny] > maxValue) {
                    nextX = nx;
                    nextY = ny;
                    maxValue = graph[nx][ny];
                    break;
                }
            }

            // 더 이상 이동할 곳이 없으면 종료
            if (nextX == -1 && nextY == -1) {
                break;
            }

            // 다음 위치로 이동
            x = nextX;
            y = nextY;
            sb.append(graph[x][y]).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}