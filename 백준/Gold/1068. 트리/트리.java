import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int removeNode;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i; 
            } else {
                tree[parent].add(i); 
            }
        }


        removeNode = Integer.parseInt(br.readLine());

        if (removeNode == root) {
            System.out.println(0);
            return;
        }

        DFS(root);
        System.out.println(result);
    }

    public static void DFS(int currentNode) {
        if (currentNode == removeNode) {
        	return;
        }

        boolean isLeaf = true;
        for (int child : tree[currentNode]) {
            if (child != removeNode) {
                isLeaf = false;
                DFS(child);
            }
        }
        
        if (isLeaf) {
        	result++;
        }
    }
}
