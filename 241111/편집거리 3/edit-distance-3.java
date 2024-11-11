import java.io.*;
import java.util.*;

public class Main {
    static String A,B;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        simulate();
    }
    
    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        dp = new int[A.length()+1][B.length()+1];

        for(int i = 0 ; i<=A.length(); i++ ) {
            Arrays.fill(dp[i],-1);
        }

        int result = dp(A.length(),B.length());
        System.out.println(result);
    }

    private static int dp(int aIndex, int bIndex) {
        if(aIndex == 0) return bIndex;
        if(bIndex == 0) return aIndex;

        if(dp[aIndex][bIndex]!=-1) {
            return dp[aIndex][bIndex];
        }

        dp[aIndex][bIndex] = 1_000_001;

        char aCh = A.charAt(aIndex-1);
        char bCh = B.charAt(bIndex-1);

        if(aCh == bCh) {
            int result = dp(aIndex-1,bIndex-1);
            dp[aIndex][bIndex] = Math.min(dp[aIndex][bIndex],result);
        }else {
            int delete = dp(aIndex-1,bIndex)+1;
            int insert = dp(aIndex,bIndex-1)+1;

            int result = Math.min(delete,insert);
            dp[aIndex][bIndex] = Math.min(dp[aIndex][bIndex],result);
        }

        return dp[aIndex][bIndex];
    }
}