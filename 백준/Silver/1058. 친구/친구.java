import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] friends;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        friends = new char[N][N];

        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            int depth = 0;
            int count = 0;

            while (depth < 2) {
                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    int n = queue.poll();

                    for (int k = 0; k < N; k++) {
                        if (friends[n][k] == 'Y' && !visited[k]) {
                            queue.add(k);
                            visited[k] = true;
                            count++;
                        }
                    }
                }
                depth++;
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}