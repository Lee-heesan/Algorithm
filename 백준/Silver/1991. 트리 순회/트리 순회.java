import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int [][] tree;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2]; 

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int root = str[0].charAt(0) - 'A'; 
            char left = str[1].charAt(0); 
            char right = str[2].charAt(0); 

           
            if (left == '.') {
                tree[root][0] = -1;
            } else {
                tree[root][0] = left - 'A';
            }

            if (right == '.') {
                tree[root][1] = -1;
            } else {
                tree[root][1] = right - 'A';
            }
        }


        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0); 
        System.out.println();
    }

    public static void preOrder(int node) {
        if (node == -1) {
            return;
        }
        System.out.print((char) (node + 'A')); 
        preOrder(tree[node][0]); 
        preOrder(tree[node][1]);
    }

    public static void inOrder(int node) {
        if (node == -1) {
            return;
        }
        inOrder(tree[node][0]); 
        System.out.print((char) (node + 'A'));
        inOrder(tree[node][1]);
    }

    public static void postOrder(int node) {
        if (node == -1) {
            return;
        }
        postOrder(tree[node][0]); 
        postOrder(tree[node][1]); 
        System.out.print((char) (node + 'A')); 
    }
}