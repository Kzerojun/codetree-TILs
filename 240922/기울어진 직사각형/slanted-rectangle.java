import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] graph;
    static int[] dx ={-1,-1,1,1};
    static int[] dy ={1,-1,-1,1};
    static int result;
    
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        init();
        simulate();
    }
    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i = 0; i<n; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MIN_VALUE;
    }

    private static void simulate() {
        for(int i = 0 ; i<n; i++) {
            for(int j= 0 ; j<n; j++) {
                dfs(i,j,i,j,0,0);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int goalX, int goalY, int nowX, int nowY,int sum, int direction) {
        if(nowX<0 || nowY<0 || nowX>=n || nowY>=n) return;

        if(direction == 3 && nowX == goalX && nowY == goalY) {
            result = Math.max(result,sum);
            return;
        }

        if(direction == 4) {
            return;
        }

        sum = sum+ graph[nowX][nowY];
        int nx = nowX + dx[direction];
        int ny = nowY + dy[direction];

        dfs(goalX,goalY,nx,ny,sum,direction);
        dfs(goalX,goalY,nx,ny,sum,direction+1);
        
    }
}