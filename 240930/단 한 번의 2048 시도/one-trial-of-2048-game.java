import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static String direction;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[4][4];

        for(int i = 0 ; i<4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<4; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        direction = br.readLine();
    }

    private static void simulate() {
        if(direction.equals("L")) {
            left();
        }
        if(direction.equals("R")) {
            right();
        }
        if(direction.equals("U")) {
            up();
        }
        if(direction.equals("D")) {
            down();
        }

        for(int i = 0 ; i<4; i++) {
            for(int j = 0; j<4; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void left() {
        for(int i = 0 ; i<4; i++) {
            for(int j =0; j<3; j++) {
                int now = board[i][j];
                int next = board[i][j+1];

                if(next == now) {
                    board[i][j] = now*2;
                    board[i][j+1] = 0;
                    j++;
                }
            }
        }
        int[][] tmp = new int[4][4];

        for(int i = 0 ; i<4; i++) {
            int index = 0;
            for(int j = 0 ; j<4; j++) {
                if(board[i][j]!= 0) {
                    tmp[i][index++] = board[i][j];
                }
            }
        }

        board = tmp;

    }

    private static void right() {
        for(int i = 0 ; i<4; i++) {
            for(int j = 3; j>1; j--) {
                int now = board[i][j];
                int next = board[i][j-1];

                if(next == now) {
                    board[i][j] = now*2;
                    board[i][j-1] = 0;
                    j--;
                }
            }
        }

        int[][] tmp = new int[4][4];
        
        for(int i = 0 ; i<4; i++) {
            int index = 3;
            for(int j = 3; j>=0; j--) {
                if(board[i][j]!= 0) {
                    tmp[i][index--] = board[i][j];
                }
            }
        }
        board = tmp;
    }

    private static void down() {
        for(int j = 0 ; j<4; j++) {
            for(int i = 3 ; i>=1; i--) {
                int now = board[i][j];
                int next = board[i-1][j];

                if(next == now) {
                    board[i][j] = now*2;
                    board[i-1][j] = 0;
                    i--;
                }
            }
        }

        // 빈 공간 채우기
    int[][] tmp = new int[4][4];
    for (int j = 0; j < 4; j++) {
        int index = 3;
        for (int i = 3; i >= 0; i--) {
            if (board[i][j] != 0) {
                tmp[index--][j] = board[i][j];
            }
        }
    }
    board = tmp;
    }

    private static void up() {
        for(int j = 0 ; j<4; j++) {
            for(int i = 0 ; i<3; i++) {
                int now = board[i][j];
                int next = board[i+1][j];

                if(next == now) {
                    board[i][j] = now*2;
                    board[i+1][j] = 0;
                    i++;
                }
            }
        }

            // 빈 공간 채우기
    int[][] tmp = new int[4][4];
    for (int j = 0; j < 4; j++) {
        int index = 0;
        for (int i = 0; i < 4; i++) {
            if (board[i][j] != 0) {
                tmp[index++][j] = board[i][j];
            }
        }
    }
    board = tmp;
    }
}