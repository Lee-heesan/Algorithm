import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> pre = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (true) {
            line = br.readLine();
            if (line == null) break;
            if (line.isEmpty()) continue;
            pre.add(Integer.parseInt(line));
        }

        postOrder(0, pre.size() - 1);
        System.out.print(sb.toString());
    }

    static void postOrder(int l, int r) {
        if (l > r) return;

        int root = pre.get(l);

        int m = l + 1;
        while (m <= r && pre.get(m) < root) m++;

        postOrder(l + 1, m - 1);
        postOrder(m, r);
        sb.append(root).append('\n');
    }
}
