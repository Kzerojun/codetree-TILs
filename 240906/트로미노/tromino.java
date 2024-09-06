import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] graph;
    static int[] dx ={0,0,-1,1};
    static int[] dy ={-1,1,0,0};
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        start();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        for(int i = 0 ; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j= 0 ;j <m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void start() {
        for(int i= 0 ; i<n; i++) {
            for(int j =0 ; j<m; j++) {
                dfs(new boolean[n][m],i,j,new ArrayList<>());
            }
        }

        System.out.println(result);
    }

    private static void dfs(boolean[][] visited, int x, int y, List<Location> tmp) {
        if(tmp.size() == 3) {
            calBlock(tmp);
            return;
        }

        for(int i = 0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if(nx< 0 || ny< 0 || nx>=n || ny>=m || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            tmp.add(new Location(nx,ny));
            dfs(visited,nx,ny,tmp);
            visited[nx][ny] = false;
            tmp.remove(tmp.size()-1);
        }
    }

    private static void calBlock(List<Location> comb ) {
        int sum  = 0;

        for(Location location : comb) {
            sum += graph[location.x][location.y];
        }
        result = Math.max(sum,result);
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