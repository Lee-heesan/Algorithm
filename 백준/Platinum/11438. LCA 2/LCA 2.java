import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxK;
    static List<Integer>[] tree;
    static int[] depth;
    static int[][] parentK;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        // maxK 계산 
        maxK = 0;
        int tmp = N;
        while (tmp > 0) {
            tmp /= 2;
            maxK++;
        }

        parentK = new int[maxK + 1][N + 1];

        bfs(1);

        // 1. 부모 노드 저장 배열 만들기
        for (int i = 1; i <= maxK; i++) {
            for (int j = 1; j <= N; j++) {
                if (parentK[i - 1][j] != 0) {
                    parentK[i][j] = parentK[i - 1][parentK[i - 1][j]];
                }
            }
        }

        // 쿼리 처리
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findLCA(a, b)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        depth[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : tree[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[now] + 1;
                    parentK[0][next] = now;
                    q.add(next);
                }
            }
        }
    }

    private static int findLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        //2. 깊이 맞추기
        // 첫 번째 방법(시간 초과)
//        while (depth[b] > depth[a]) {
//            b = parentK[0][b];  
//        } 
//
        // 두 번째 방법(시간 초과)
//        while (depth[b] > depth[a]) {
//            if (depth[b] - depth[a] >= 8) {
//                b = parentK[3][b]; 
//            } else if (depth[b] - depth[a] >= 4) {
//                b = parentK[2][b];
//            } else if (depth[b] - depth[a] >= 2) {
//                b = parentK[1][b];
//            } else {
//                b = parentK[0][b];
//            }
//        }
        
        // 세 번째 방법
        int diff = depth[b] - depth[a];

        for (int i = 0; diff > 0; i++) {
            if ((diff & 1) == 1) {
                b = parentK[i][b];
            }
            diff >>= 1;
        }




        if (a == b) return a;
        
        //3.최소 공통 조상 찾기
        for (int i = maxK; i >= 0; i--) {
            if (parentK[i][a] != parentK[i][b]) {
                a = parentK[i][a];
                b = parentK[i][b];
            }
        }

        return parentK[0][a];
    }
}
