import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    static List<Command> commands;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        simulate();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int index = 0;
        for(int i = 0 ; i<n; i++) {
            arr[index++] = Integer.parseInt(br.readLine()); 
        }

        commands = new ArrayList<>();

        for(int i = 0 ; i<2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            commands.add(new Command(start,end));    
        }
    }

    private static void simulate() {
        for(Command c : commands) {
            int[] tmp = new int[n];

            for(int i = c.start; i<=c.end; i++) {
                arr[i] = 0;
            }

            int index = 0;
            for(int i = 0; i<n; i++) {
                if(arr[i]!=0) {
                    tmp[index++] = arr[i];
                }
            }
            arr = tmp;
        }

        int count = 0;
        for(int i = 0 ;i <n; i++ ) {
            if(arr[i] == 0 ) break;
            count++;
        }

        System.out.println(count);

        for(int i = 0 ;i <n; i++ ) {
            if(arr[i] == 0 ) break;
            System.out.println(arr[i]);
        }
    }

}

class Command {
    int start;
    int end;

    Command(int start, int end) {
        this.start = start;
        this.end = end;
    }
}