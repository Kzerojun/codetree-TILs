import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int N, M;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void simulate() {
        while (true) {
            boolean found = false; // 터질 폭탄이 있는지 체크하는 변수

            for (int i = 0; i < N; i++) {
                int now = numbers[i];
                if(now == 0) {
                	continue;
                }
                int startIndex = i;
                int next = i + 1;
                int count = 1;

                // 연속된 같은 숫자를 찾는 while문
                while (next < N && numbers[next] == now) {
                    count++;
                    next++;
                }

                // M개 이상 연속된 숫자 폭탄들을 0으로 만듦
                if (count >= M) {
                    found = true; // 터질 폭탄이 있음을 표시
                    for (int j = startIndex; j < next; j++) {
                        numbers[j] = 0;
                    }
                }
            }

            // 터질 폭탄이 없으면 종료
            if (!found) {
                break;
            }

            // 폭탄이 터지고 남은 폭탄들이 아래로 떨어짐
            drop();
        }

        // 결과 계산 및 출력
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (numbers[i] != 0) {
                result++;
            } else {
                break;
            }
        }

        System.out.println(result);
        for (int i = 0; i < N; i++) {
            if (numbers[i] != 0) {
                System.out.println(numbers[i]);
            } else {
                break;
            }
        }
    }

    private static void drop() {
        int[] tmp = new int[N];
        int index = 0;

        for (int i = 0; i < N; i++) {
            if (numbers[i] != 0) {
                tmp[index++] = numbers[i];
            }
        }

        numbers = tmp;
    }
}