import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int N,M,Q;
    static List<Command> commands;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        for(int i = 0 ;i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        commands = new ArrayList<>();

        for(int i = 0 ; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            commands.add(new Command(x1,y1,x2,y2));
        }
    }

    private static void simulate() {
        for(Command command : commands) {
            rotate(command);
            cal(command);
        }

        for(int i = 0; i<N; i++) {
            for(int j =0  ;j <M; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotate(Command command) {
        int x1 = command.x1;
        int x2 = command.x2;
        int y1 = command.y1;
        int y2 = command.y2;

        int tmp = graph[x1][y1];

        for(int i = x1; i<x2; i++) {
            graph[i][y1] = graph[i+1][y1];
        }
        for(int j = y1; j<y2; j++) {
            graph[x2][j] = graph[x2][j+1];
        }
        for(int i = x2; i>x1; i--) {
            graph[i][y2] = graph[i-1][y2];
        }
        for(int j = y2; j>y1; j--) {
            graph[x1][j] = graph[x1][j-1];
        }

        graph[x1][y1+1] = tmp;
        
    }

    private static void cal(Command command) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            tmp[i] = Arrays.copyOf(graph[i], graph[i].length);
        }

        for(int i = command.x1; i<=command.x2; i++) {
            for(int j = command.y1; j<=command.y2; j++) {
                fourSearch(i,j,tmp);
            }
        }

        graph = tmp;
    }

    private static void fourSearch(int x, int y, int[][] tmp) {
        int count = 1;

        for(int i =0 ; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx< 0 || ny<0 || nx>=N || ny>=M) continue;
            
            count++;
            tmp[x][y] += graph[nx][ny];
        }

        tmp[x][y] = tmp[x][y]/count;
    }


}

class Command {
    int x1;
    int y1;
    int x2;
    int y2;

    Command(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}