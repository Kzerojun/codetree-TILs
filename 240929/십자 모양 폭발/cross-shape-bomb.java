import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] graph;
    static int bombX, bombY;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i = 0 ; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        bombX = Integer.parseInt(st.nextToken())-1;
        bombY = Integer.parseInt(st.nextToken())-1;
    }

    private static void simulate() {
        int moveCount = graph[bombX][bombY];
        for(int i = 0 ; i<4; i++) {
            dfs(bombX,bombY,i,1,moveCount);
        }

        drop();

        for(int i =0  ;i <n; i++) {
            for(int j = 0 ; j<n; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void dfs(int x, int y,int direction, int moveCount,int maxMoveCount) {
        graph[x][y] = 0;

        int nx = dx[direction] + x;
        int ny = dy[direction] + y;

        if(nx<0 || ny<0 || nx>=n || ny>=n || moveCount+1 > maxMoveCount) return;
        dfs(nx,ny,direction,moveCount+1,maxMoveCount);
    }

    private static void drop() {
        int[][] tmp = new int[n][n];

        for(int j = 0; j<n; j++) {
            int index = n-1;
            for(int i = n-1; i>=0; i--) {
                if(graph[i][j]!=0) {
                    tmp[index--][j] = graph[i][j];
                }
            }
        }

        graph = tmp;

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