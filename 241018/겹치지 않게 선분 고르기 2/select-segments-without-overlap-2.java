import java.util.*;
import java.io.*;


public class Main {
    static int n;
    static Line[] lines;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
    }

    private static void init() throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        lines = new Line[n];
        dp = new int[n];

        for(int i = 0 ; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i] = -1;
            
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            lines[i] = new Line(x1,x2);
        }

        Arrays.sort(lines,(o1,o2)-> {
            return o1.x1 - o2.x1;
        });

        int result = dfs(0);

        System.out.println(result);
    }

    private static int dfs(int index) {
        if(index>=n) {
            return -10001;
        }
        if(dp[index]!= -1) {
            return dp[index];
        }

        int notSelect = dfs(index+1);

        dp[index] = 1;

        for(int i = index+1; i<n; i++) {
            if(lines[i].x1 > lines[index].x2) {
                int result = dfs(i);
                dp[index] = Math.max(dp[index],result+1);
            }
        }

        return dp[index] = Math.max(notSelect,dp[index]);

        
    }
}

class Line{
    int x1;
    int x2;

    Line(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}