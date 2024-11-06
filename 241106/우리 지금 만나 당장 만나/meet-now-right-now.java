import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] locations;
    static int[] speeds;


    public static void main(String[] args) throws IOException {
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        locations = new int[n];
        speeds = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<n; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<n; i++) {
            speeds[i] = Integer.parseInt(st.nextToken());
        }

        double left = 0;
        double right = 1_000_000_000;

        for(int i =0; i<=100; i++) {
            double mid = (left+right)/2;

            if(isPossible(mid)) {
                right = mid;
            }else {
                left = mid;
            }
        }

        System.out.printf("%.4f",left);
    }

    private static boolean isPossible(double mid) {
        double minLocation = locations[0] - speeds[0] * mid;
        double maxLocation = locations[0] + speeds[0] * mid;

        for(int i = 1; i<n; i++) {
            minLocation = Math.max(minLocation,locations[i] - speeds[i]*mid);
            maxLocation = Math.min(maxLocation,locations[i] + speeds[i]*mid);
        }

        return minLocation <= maxLocation;
    }
}