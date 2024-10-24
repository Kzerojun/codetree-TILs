import java.util.*;
import java.io.*;

public class Main {
   static int N;
   static int[][] graph;
   static int[] dx = {-1, 1, 0, 0};
   static int[] dy = {0, 0, 1, -1};

   public static void main(String[] args) throws IOException {
       simulate();
   }

   private static void simulate() throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       N = Integer.parseInt(br.readLine());
       graph = new int[N][N];

       for(int i = 0; i < N; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j = 0; j < N; j++) {
               graph[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       int left = 0;
       int right = 1_000_000;

       while(left <= right) {
           int mid = (left + right) / 2;

           if(isPossible(mid)) {
               right = mid -1;
           } else {
               left = mid + 1;
           }
       }

       System.out.println(left);
   }

   private static boolean isPossible(int mid) {
       boolean[][] visited = new boolean[N][N];

       for(int i = 0; i < N; i++) {
           for(int j = 0; j < N; j++) {
               if(!visited[i][j]) {
                    int result = move(i, j, visited,mid);
                   if(result>= N*N/2) {
                        return true;
                   }
               }
           }
       }
       return false;
   }

   private static int move(int x, int y, boolean[][] visited,int mid) {
       Queue<Location> q = new LinkedList<>();
       q.add(new Location(x, y));
       visited[x][y] = true;

       int moveCount = 0;

       while(!q.isEmpty()) {
           Location now = q.poll();
           moveCount++;

           for(int i = 0; i < 4; i++) {
               int nx = dx[i] + now.x;
               int ny = dy[i] + now.y;

               if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                if(Math.abs(graph[now.x][now.y] - graph[nx][ny])<= mid) {
                    visited[nx][ny] = true;
                     q.add(new Location(nx, ny));
                }


           }
       }

       return moveCount;
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