import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Q;
    static int[][] graph;
    static List<Command> commands;

    public static void main(String[] args) throws IOException {
        init();    // 초기화 메서드 호출
        simulate(); // 명령어 실행 메서드 호출
        printGraph(); // 최종 결과 출력
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        commands = new ArrayList<>();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            commands.add(new Command(Integer.parseInt(st.nextToken()) - 1, st.nextToken()));  // 행 번호는 0부터 시작하므로 -1
        }
    }

    private static void simulate() {
        for (Command command : commands) {
            if (command.command.equals("L")) {
                leftPush(command.row);
                propagate(command.row, "L");
            } else if (command.command.equals("R")) {
                rightPush(command.row);
                propagate(command.row, "R");
            }
        }
    }

    private static void propagate(int row, String direction) {
        // 위쪽 전파
        boolean currentDirection = direction.equals("L"); // 현재 방향이 L인지 R인지 저장
        for(int i = row-1; i>=0; i--) {
            if(checkSameInRow(i,i+1)) {
                if (currentDirection) {
                    rightPush(i);
                } else {
                    leftPush(i);
                }
                currentDirection = !currentDirection;
            }else {
                break;
            }
        }

        currentDirection = direction.equals("L"); // 현재 방향이 L인지 R인지 저장
        for(int i = row+1; i<N; i++) {
            if(checkSameInRow(i,i-1)) {
                if (currentDirection) {
                    rightPush(i);
                } else {
                    leftPush(i);
                }
                currentDirection = !currentDirection;
            }else {
                break;
            }
        }
    } 

    private static boolean checkSameInRow(int row1, int row2) {
        // 두 행에서 같은 열에 같은 숫자가 하나라도 있는지 확인
        for (int j = 0; j < M; j++) {
            if (graph[row1][j] == graph[row2][j]) {
                return true;
            }
        }
        return false;
    }

    private static void leftPush(int row) {
        int tmp = graph[row][M - 1];

        for (int j = M - 1; j >= 1; j--) {
            graph[row][j] = graph[row][j - 1];
        }

        graph[row][0] = tmp;
    }

    private static void rightPush(int row) {
        int tmp = graph[row][0];

        for (int j = 0; j < M - 1; j++) {
            graph[row][j] = graph[row][j + 1];
        }

        graph[row][M - 1] = tmp;
    }

    private static void printGraph() {
        // 그래프 상태를 출력하는 메서드
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Command {
    int row;
    String command;

    Command(int row, String command) {
        this.row = row;
        this.command = command;
    }
}