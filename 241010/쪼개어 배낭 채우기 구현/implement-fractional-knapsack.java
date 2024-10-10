import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static List<Jewel> jewels;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jewels = new ArrayList<>();

        for(int i = 0 ; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight,(double)value/weight));
        }

        jewels.sort((o1,o2)->{
            return Double.compare(o2.weightPerPrice,o1.weightPerPrice);
        });

        double result = 0;

        for(Jewel jewel : jewels) {
            if(jewel.weight < M) {
                result += jewel.weightPerPrice * jewel.weight;
                M -= jewel.weight;
            }else {
                result += (jewel.weightPerPrice * M);
                break;
            }
        }

        System.out.printf("%.3f",result);
    }


}

class Jewel {
    int weight;
    double weightPerPrice;
    
    Jewel(int weight, double weightPerPrice) {
        this.weight = weight;
        this.weightPerPrice = weightPerPrice;
    }
}