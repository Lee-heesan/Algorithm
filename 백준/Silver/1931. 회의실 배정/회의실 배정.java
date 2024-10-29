
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int count;
    static PriorityQueue<int[]> PQ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료 시간이 같을 경우 시작 시간이 빠른 순으로 정렬
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            PQ.add(new int[]{start, end});
        }

        count = 0;
        int lastEndTime = 0;

        while (!PQ.isEmpty()) {
            int[] meeting = PQ.poll();
            // 현재 회의의 시작 시간이 마지막 종료 시간 이후라면 회의 배정
            if (meeting[0] >= lastEndTime) {
                lastEndTime = meeting[1];
                count++;
            }
        }

        System.out.println(count);
    }
}
