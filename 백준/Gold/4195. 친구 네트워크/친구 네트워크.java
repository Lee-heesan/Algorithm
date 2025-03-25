import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int F;
    static Map<String, String> parent;
    static Map<String, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            F = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            size = new HashMap<>();

            for (int j = 0; j < F; j++) {
                st = new StringTokenizer(br.readLine());
                String A = st.nextToken();
                String B = st.nextToken();

                sb.append(union(A, B)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int union(String p1, String p2) {
        String rootA = find(p1);
        String rootB = find(p2);

        if (!rootA.equals(rootB)) {
            int sizeA = size.get(rootA);
            int sizeB = size.get(rootB);

            if (sizeA > sizeB) {
                parent.put(rootB, rootA);
                size.put(rootA, sizeA + sizeB);
                return sizeA + sizeB;
            } else {
                parent.put(rootA, rootB);
                size.put(rootB, sizeA + sizeB);
                return sizeA + sizeB;
            }
        }
        return size.get(rootA);
    }
    
    private static String find(String person) {
        if (!parent.containsKey(person)) {
            parent.put(person, person);
            size.put(person, 1);
            return person;
        }
        if (!parent.get(person).equals(person)) {
            parent.put(person, find(parent.get(person))); 
        }
        return parent.get(person);
    }
}
