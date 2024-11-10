import java.util.*;
import java.io.*;

public class Main {
    static String A,B;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();

        //A의 문자열 길이, B의 문자열길이
        dp = new int[A.length()][B.length()];
        for(int i = 0; i < A.length(); i++) {
           Arrays.fill(dp[i],-1);
        }

        int result = dfs(A.length()-1,B.length()-1);

        System.out.println(result);
    }

    private static int dfs(int aIndex, int bIndex) {
        if(aIndex <0 || bIndex<0) {
            return 0;
        }

        if(dp[aIndex][bIndex]!=-1) {
            return dp[aIndex][bIndex];
        }


        dp[aIndex][bIndex] = 0;

        char aCh = A.charAt(aIndex);
        char bCh = B.charAt(bIndex);

        if(aCh == bCh) {
            int result = dfs(aIndex-1,bIndex-1);
            dp[aIndex][bIndex] = Math.max(dp[aIndex][bIndex],result+1);
        }else {
            int left = dfs(aIndex-1,bIndex);
            int right = dfs(aIndex,bIndex-1);

            int max = Math.max(left,right);
            dp[aIndex][bIndex] = Math.max(dp[aIndex][bIndex],max);
        }

        return dp[aIndex][bIndex];
    }
}