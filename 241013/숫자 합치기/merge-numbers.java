import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void simulate() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o1 - o2;
        });

        pq.addAll(numbers);

        int result = 0;

        while(pq.size()>1) {
            int first = pq.poll();
            int second = pq.poll();


            int next = first + second;
            result += next;
            pq.add(next);
        }


        System.out.println(result);
    }
}