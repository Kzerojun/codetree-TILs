import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static BufferedReader br;
    static HashMap<Integer,Integer> hashmap;
    public static void main(String[] args) throws IOException {
        init();
        start();
    }
    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hashmap = new HashMap<>();
    }

    private static void start()throws IOException {
        for(int i = 0 ; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                hashmap.put(key,value);
            }

            if(command.equals("find")) {
                int key = Integer.parseInt(st.nextToken());
                if(!hashmap.containsKey(key)) {
                    System.out.println("None");
                }else {
                    System.out.println(hashmap.get(key));
                }
            }
            if(command.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                hashmap.remove(key);
            }
        }
    }
}