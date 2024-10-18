import java.util.*;
import java.io.*;

public class Main {
    static int N; // 목표 합
    static int[] arr; // 사용할 수 있는 수들 (1, 2, 5)
    static int[] dp; // 메모이제이션 배열

    public static void main(String[] args) throws IOException {
        init(); // 초기화
        System.out.println(dfs(N)); // 목표 합 N을 만들기 위한 방법 수 출력
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 목표 합 입력

        arr = new int[]{1, 2, 5}; // 사용할 수 있는 수
        dp = new int[N + 1]; // dp 배열 초기화

        Arrays.fill(dp, -1); // dp 배열을 -1로 초기화하여 메모이제이션을 위한 기본값 설정
    }

    private static int dfs(int target) {
        if (target == 0) {
            return 1; // 목표 합이 0일 경우 1가지 방법 (아무 것도 선택하지 않음)
        }

        if (target < 0) {
            return 0; // 목표 합이 음수일 경우 방법이 없음
        }

        // 이미 계산된 값이 있을 경우, 해당 값 반환
        if (dp[target] != -1) {
            return dp[target];
        }

        dp[target] = 0; // 현재 목표 합을 만들기 위한 방법 수 초기화
        for (int i = 0; i < arr.length; i++) {
            dp[target] += dfs(target - arr[i]); // 사용 가능한 수를 빼고 재귀 호출
            dp[target] %= 10_007; // 결과가 너무 커지는 것을 방지
        }

        return dp[target]; // 목표 합을 만드는 방법 수 반환
    }
}