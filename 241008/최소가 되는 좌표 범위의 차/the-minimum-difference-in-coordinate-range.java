import java.util.*;
import java.io.*;

public class Main {
    static int N, D;
    static Location[] locations;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        locations = new Location[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            locations[i] = new Location(x, y);
        }

        Arrays.sort(locations, (o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
    }

    private static void simulate() {
        int result = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < N; right++) {
            while (locations[right].y - locations[left].y >= D) {
                result = Math.min(result, locations[right].x - locations[left].x);
                left++;
            }
        }

 
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}

class Location {
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}