import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        init();
        boolean check = simulate();
        if(check) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        

        A = new int[n+1];
        B = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static boolean simulate() {
    int j = 1;  // 배열 A의 인덱스를 가리키는 변수
    
    // 배열 B의 각 요소를 확인하면서 배열 A에서 같은 값을 찾는다
    for (int i = 1; i <= m; i++) {
        // 배열 A에서 B[i]와 같은 값을 찾을 때까지 j를 증가시킨다
        while (j <= n && B[i] != A[j]) {
            j++;
        }

        // 만약 A 배열을 모두 다 탐색했는데도 B[i]와 같은 값을 찾지 못한 경우
        if (j == n + 1) {
            return false;  // 배열 A에서 B의 순서를 찾을 수 없다
        }
    }

    // 배열 B의 모든 요소가 배열 A에서 순서대로 발견된 경우
    return true;
}

}