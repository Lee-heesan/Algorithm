import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long x, a;
        Node(long x, long a) { this.x = x; this.a = a; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N];
        long total = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            arr[i] = new Node(x, a);
            total += a;
        }

        Arrays.sort(arr, Comparator.comparingLong(o -> o.x));

        long target = (total + 1) / 2; // 절반 이상(올림)
        long prefix = 0;

        for (Node n : arr) {
            prefix += n.a;
            if (prefix >= target) {
                System.out.println(n.x);
                return;
            }
        }
    }
}