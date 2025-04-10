import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int N, M;
    static int[] inDegree, array;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int time = 1; time <= T; time++) {
            // N은 사람 수, M은 변경된 순서 쌍의 수
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            // 초기 배열 초기화
            inDegree = new int[N + 1];
            array = new int[N + 1];
            list = new ArrayList[N + 1];

            // 각 사람의 순서 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            // 각 사람에 대한 연결 리스트 초기화
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            // 기본 관계 설정
            for (int i = 1; i <= N; i++) {
                int from = array[i];
                for (int j = i + 1; j <= N; j++) {
                    list[from].add(array[j]);
                    inDegree[array[j]]++;
                }
            }

            // 변경된 관계 처리
            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int front = Integer.parseInt(st.nextToken());
                int back = Integer.parseInt(st.nextToken());

                if (list[front].contains(back)) {
                    list[front].remove((Integer) back);
                    list[back].add(front);
                    inDegree[front]++;
                    inDegree[back]--;
                } else {
                    list[back].remove((Integer) front);
                    list[front].add(back);
                    inDegree[back]++;
                    inDegree[front]--;
                }
            }

            // 위상 정렬을 위한 큐
            StringBuilder sb = new StringBuilder();
            Queue<Integer> queue = new LinkedList<>();

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    cnt++;
                    queue.add(i);
                }
            }

            if (cnt > 1) {
                System.out.println("?");
                continue;
            }

            int result = 0;
            boolean isFinished = false;
            for (int i = 1; i <= N; i++) {
                if (queue.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    isFinished = true;
                    break;
                }

                int from = queue.poll();
                result++;
                sb.append(from).append(" ");
                for (int to : list[from]) {
                    inDegree[to]--;
                    if (inDegree[to] == 0) queue.add(to);
                }
            }

            if (isFinished) continue;

            System.out.println(sb.toString());
        }
    }
}
