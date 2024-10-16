import java.util.*;
import java.io.*;

public class Main {
    static Line[] lines;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.

        init();
        for(int i = 0 ; i<n; i++) {
            if(dp[i]==-1) {
                dfs(i);
            }
        }

        int result = 1;
        for(int i =0  ; i<n; i++) {
            result = Math.max(result,dp[i]);
        }

        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lines = new Line[n];
        dp = new int[n];

        for(int i = 0 ; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            lines[i] = new Line(x1,x2);
            dp[i] = -1;
        }

        Arrays.sort(lines,(o1,o2)->{
            if(o1.x1 == o2.x1) {
                return o1.x2 - o2.x2;
            }

            return o1.x1 - o2.x1;
        });
    }

    private static int dfs(int index) {
        if(dp[index]!= -1) {
            return dp[index];
        }

        dp[index] = 1;
        for(int i = index+1; i<n; i++) {
            if(lines[index].x2<lines[i].x1) {
                int result = dfs(i);
                dp[i] = Math.max(dp[i],result+1);
            }
        }

        return dp[index];
    }
    
}

class Line {
    int x1;
    int x2;

    Line(int x1,int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}