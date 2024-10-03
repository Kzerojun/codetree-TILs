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
        int j = 1;
        for(int i = 1; i<=m; i++) {
            while(j<n && B[i]== A[j]) {
                j++;
            }

            if(j== n+1) {
                return false;
            }else {
                i++;
            }
        }

        return true;
    }
}