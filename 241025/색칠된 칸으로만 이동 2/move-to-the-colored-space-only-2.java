import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Location> locations;
    static int MAX_LEN = 1_000_000_000;


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        locations = new ArrayList<>();

        for(int i =0 ; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j<M; j++) {
                int number = Integer.parseInt(st.nextToken());
                if(number ==1) {
                    locations.add(new Location(i,j));
                }
            }
        }

        long left = 0;
        long right = MAX_LEN;

        while(left<=right) {
            long mid = (left+right) / 2;

            if(isPossible(mid)) {
                right = mid -1;
            }else {
                left = mid +1;
            }
        }

        System.out.println(left);
    }

    private static boolean isPossible(long mid) {
        Queue<Location> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        Location start = locations.get(0);
        visited[start.x][start.y] = true;
        q.add(start);

        while(!q.isEmpty()) {
            Location now = q.poll();

            for(int i =0 ; i<4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]) continue;
                if(Math.abs(graph[now.x][now.y]-graph[nx][ny])>mid) continue;
            
                visited[nx][ny] = true;
                q.add(new Location(nx,ny));
            }
        }

        for(Location location : locations) {
            if(!visited[location.x][location.y]) {
                return false;
            }
        }

        return true;
    }


}
class Location{
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}