import java.util.Arrays;
import java.io.*;

public class Main {
    private static final int MAX_N = 19;
    private static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new long[MAX_N + 1][MAX_N + 1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        long result = countBSTs(1, N);
        System.out.println(result);
    }

    private static long countBSTs(int start, int end) {
        // 기본 케이스: 빈 트리나 단일 노드
        if (start >= end) {
            return 1;
        }

        // 이미 계산된 결과가 있는지 확인
        if (memo[start][end] != -1) {
            return memo[start][end];
        }

        long count = 0;
        // 모든 가능한 루트에 대해 반복
        for (int root = start; root <= end; root++) {
            // 왼쪽과 오른쪽 서브트리의 개수를 계산
            long leftCount = countBSTs(start, root - 1);
            long rightCount = countBSTs(root + 1, end);
            
            // 전체 개수는 왼쪽과 오른쪽 서브트리 개수의 곱
            count += leftCount * rightCount;
        }

        // 결과를 메모이제이션
        memo[start][end] = count;
        return count;
    }
}