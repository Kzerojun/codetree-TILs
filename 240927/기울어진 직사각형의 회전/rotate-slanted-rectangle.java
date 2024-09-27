import java.util.*;
import java.io.*;

public class Main {
    static int[] dx ={-1,-1,1,1};
    static int[] dy = {1,-1,-1,1};
    static int n;
    static int[][] graph;
    static Command command;
    static List<Integer> numbers;
    static int index = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for(int i = 0 ; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        command = new Command(r,c,m1,m2,m3,m4,direction);

        numbers = new ArrayList<>();
    }

    private static void simulate() {
        Location location = new Location(command.r,command.c);
        move(location,0,command.m1);
        move(location,1,command.m2);
        move(location,2,command.m3);
        move(location,3,command.m4);

        location = new Location(command.r,command.c);

        if(command.direction == 0) {
            Collections.rotate(numbers,1);
            exchange(location,0,command.m1);
            exchange(location,1,command.m2);
            exchange(location,2,command.m3);
            exchange(location,3,command.m4);
            
        }else {
            int index = 0;
            Collections.rotate(numbers,-1);
            exchange(location,0,command.m1);
            exchange(location,1,command.m2);
            exchange(location,2,command.m3);
            exchange(location,3,command.m4);
        }

        for(int i =0 ; i<n; i++) {
            for(int j = 0 ;j <n; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        

    }
    private static void move(Location location, int i, int count) {
        int nx = location.x;
        int ny = location.y;

        for(int k =0; k<count; k++) {
            nx = dx[i] + nx;
            ny = dy[i] + ny;

            numbers.add(graph[nx][ny]);
        }

        location.x = nx;
        location.y = ny;  
    }

    private static void exchange(Location location, int i, int count) {
        int nx = location.x;
        int ny = location.y;

        for(int k =0; k<count; k++) {
            nx = dx[i] + nx;
            ny = dy[i] + ny;

            graph[nx][ny] = numbers.get(index++);
        }
        location.x = nx;
        location.y = ny;  
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

class Command {
    int r;
    int c;
    int m1;
    int m2;
    int m3;
    int m4;
    int direction;

    Command(int r, int c, int m1, int m2, int m3, int m4, int direction) {
        this.r = r;
        this.c = c;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.direction = direction;
    }
}