import java.util.*;
import java.io.*;

public class Main {
    static int N,M;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.

        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            trie.insert(st.nextToken());
        }

        trie.sol(br.readLine());
        
    }
}

class Trie{
    private final TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode current = root;

        for(char ch : str.toCharArray()) {
            current.child.putIfAbsent(ch, new TrieNode());
            current = current.child.get(ch);
            current.num++;
        }

        current.isTerminal = true;
    }

    public void sol(String str) {
        TrieNode current = root;

        for(char ch : str.toCharArray()) {
            if(current.child.containsKey(ch)) {
                current = current.child.get(ch);
                System.out.print(current.num+" ");
            }else {
                System.out.print(0+" ");
            }
        }
        
    }
    
}

class TrieNode {
    boolean isTerminal;
    int num;
    Map<Character,TrieNode> child;

    TrieNode() {
        this.isTerminal = false;
        this.child = new TreeMap<>();
        this.num = 0;
    }
}