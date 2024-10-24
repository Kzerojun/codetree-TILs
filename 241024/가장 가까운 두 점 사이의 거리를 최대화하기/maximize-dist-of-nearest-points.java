import java.io.*;
import java.util.*;

public class Main {

    static int MAX_LEN = 1_000_000_000;
    static int n;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Line[] lines = new Line[n];
        for(int i =0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            lines[i] = new Line(a,b);
        }

        Arrays.sort(lines,(o1,o2)->{
            return o1.a - o2.a;
        });


        int left = 1;
        int right = MAX_LEN;

        while(left<=right) {
            int mid = (left + right)/2;

            if(isPossible(mid,lines)) {
                left = mid +1;
            }else {
                right = mid -1;
            }
        }

        System.out.println(left-1);

    }

    private static boolean isPossible(int dist, Line[] lines) {
        int lastIndex = lines[0].a;

        for(int i = 1; i<n; i++) {
            int a = lines[i].a;
            int b = lines[i].b;

            if(lastIndex + dist > b) {
                return false;
            }
            lastIndex = Math.max(a,lastIndex+dist);
        }

        return true;
    }
}

class Line{
    int a;
    int b;

    Line(int a, int b) {
        this.a = a;
        this.b = b;
    }
}