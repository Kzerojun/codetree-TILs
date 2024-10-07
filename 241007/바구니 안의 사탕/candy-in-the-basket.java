import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static Basket[] baskets;
    static int result;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        baskets = new Basket[N+1];

        baskets[0] = new Basket(0,0);

        for(int i = 1 ; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            
            baskets[i] = new Basket(candy,location);
        }

        Arrays.sort(baskets,(o1,o2)->{
            return o1.location - o2.location;
        });

        result = Integer.MIN_VALUE;
    }

    private static void simulate() {
        int i = 0;
        int candySum = 0;
        for(int j = 1; j<=N; j++) {
            while(i+1<=N && baskets[i+1].location - baskets[j].location <= 2*K) {
                i++;
                candySum += baskets[i].candy;
            }

            if(baskets[i].location - baskets[j].location<= 2*K) {
                result = Math.max(result,candySum);
            }

            candySum -= baskets[j].candy;
        }

        System.out.println(result);
    }
} 

class Basket{
    int candy;
    int location;

    Basket(int candy, int location) {
        this.candy = candy;
        this.location = location;
    }
}