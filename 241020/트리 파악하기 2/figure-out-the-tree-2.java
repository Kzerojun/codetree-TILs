import java.util.*;
import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for(int i = 0 ; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int k = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            for(int j =0 ; j<k; j++) {
                sb.append(st.nextToken());
            }

            tree.insert(sb.toString());
        }

        tree.sol();
    }

    
}


class Tree{
    private final Node root;

    Tree() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node current = root;

        for(char ch : str.toCharArray()) {
            current.child.putIfAbsent(ch,new Node());
            current = current.child.get(ch);
        }
    }

    public void sol() {
        sol(root,0);
    }

private void sol(Node now, int depth) {
    for(char next : now.child.keySet()) {
        for(int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println(next);
        sol(now.child.get(next), depth + 1);
    }
}
}
class Node{
    TreeMap<Character,Node> child;

    Node() {
        this.child = new TreeMap<>();
    }
}