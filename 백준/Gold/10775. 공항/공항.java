import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int G = sc.nextInt();
        int P = sc.nextInt();

        parent = new int[G + 1];

        for(int i = 0; i <= G; i++){
            parent[i] = i;
        }

        int count = 0;

        for(int i = 0; i < P; i++){
            int g = sc.nextInt();

            int root = find(g);

            if(root == 0) {
            	break;
            }

            union(root, root - 1);
            count++;
        }

        System.out.println(count);
    }

    static int find(int x){
        if(parent[x] == x) {
        	return x;
        }
        
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int A = find(a);
        int B = find(b);

        parent[A] = B;
    }
}
