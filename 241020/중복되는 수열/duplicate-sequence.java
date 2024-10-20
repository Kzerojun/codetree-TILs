import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] numbers;
    
    public static void main(String[] args) throws IOException {
        simulate();
    }

    private static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        numbers = new String[N];
        
        boolean existsPrefix = false;

        // 수열 입력 및 트라이에 삽입
        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
            trie.insert(numbers[i]);
        }

        // 각 수열에 대해 다른 수열의 접두사인지 확인
        for (int i = 0; i < N; i++) {
            if (trie.startsWith(numbers[i])) {
                existsPrefix = true;
                break;
            }
        }

        // 접두사가 존재하면 0, 그렇지 않으면 1 출력
        System.out.println(existsPrefix ? 0 : 1);
    }
}

class Trie {
    private final TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    // 수열을 삽입하는 메서드
    public void insert(String number) {
        TrieNode currentNode = root;

        for (char ch : number.toCharArray()) {
            currentNode.child.putIfAbsent(ch, new TrieNode());
            currentNode = currentNode.child.get(ch);
        }

        currentNode.isTerminal = true; // 수열의 끝을 표시
    }

    // 현재 수열이 다른 수열의 접두사인지 확인하는 메서드
    public boolean startsWith(String number) {
        TrieNode currentNode = root;

        for (char ch : number.toCharArray()) {
            currentNode = currentNode.child.get(ch);
            if (currentNode == null) {
                return false;
            }
            // 접두사가 존재하는지 확인 (자기 자신과 동일하면 안 됨)
            if (currentNode.isTerminal) {
                return true;
            }
        }

        return false; // 접두사 아님
    }
}

class TrieNode {
    boolean isTerminal;
    TreeMap<Character, TrieNode> child;

    TrieNode() {
        this.isTerminal = false;
        this.child = new TreeMap<>();
    }
}