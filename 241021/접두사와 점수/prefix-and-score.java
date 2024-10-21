import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        simulate();
    }

    public static void simulate() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<n; i++) {
            String str = st.nextToken();
            trie.insert(str);
        }

        int result = trie.solution();
        System.out.println(result);
    }
}



class Trie{
    final TrieNode root;
    int result;

    Trie() {
        this.root = new TrieNode();
        result = Integer.MIN_VALUE;
    } 

    public void insert(String str) {
        TrieNode current = root;

        for(char ch : str.toCharArray()) {
            current.child.putIfAbsent(ch,new TrieNode());
            current = current.child.get(ch);
            current.count++;
        }

        current.isTerminal = true;
    }

    public int solution() {
        solution(root,0);
        return result;
    }

    private void solution(TrieNode current, int depth) {

        if(current.isTerminal) {
            int cal = depth * current.count;
            result = Math.max(cal,result);
        }
       
        for(char ch : current.child.keySet()) {
            current = current.child.get(ch);

            if(current == null) {
                continue;
            }

            solution(current,depth+1);
        }
        
        


    }


}

class TrieNode {
    boolean isTerminal;
    Map<Character,TrieNode> child;
    int count;

    TrieNode() {
        this.isTerminal = false;
        this.child = new TreeMap<>();
        this.count = 0;
    }
}