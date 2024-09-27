import java.io.*;
import java.util.*;

public class Main {
    static int result;

    public static void main(String[] args) throws IOException {
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] ch = str.toCharArray();
        result = Integer.MAX_VALUE;

        for(int i = 0 ; i<ch.length; i++) {
            shift(ch);
        }
        System.out.println(result);
    }

    private static void shift(char[] ch) {
        char tmp = ch[ch.length-1];
        for(int i = ch.length-1; i>0; i--) {
            ch[i] = ch[i-1];
        }

        ch[0] = tmp;

        compress(ch);
    }

    private static void compress(char[] ch) {
        StringBuilder sb = new StringBuilder();
        int n = ch.length;

        for(int i = 0 ; i<n; i++) {
            char current = ch[i];
            int count = 1;

            while(i+1 <n && ch[i+1] == current) {
                count++;
                i++;
            }
            sb.append(current);
            sb.append(count);
        }

        System.out.println(sb.toString());

        result = Math.min(result,sb.toString().length());
    }

    
}