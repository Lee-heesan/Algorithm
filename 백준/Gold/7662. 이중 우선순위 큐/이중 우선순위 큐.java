import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> minHeap = new PriorityQueue<>(); // 최솟값 저장
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최댓값 저장
            Map<Long, Integer> countMap = new HashMap<>(); // 실제 존재하는 값 개수 기록

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                long num = Long.parseLong(st.nextToken());

                if (command.equals("I")) {
                    minHeap.add(num);
                    maxHeap.add(num);
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                } else if (command.equals("D")) {
                    if (countMap.isEmpty()) continue;
                    PriorityQueue<Long> targetHeap = (num == 1) ? maxHeap : minHeap;

                    while (!targetHeap.isEmpty()) {
                        long key = targetHeap.poll();
                        if (countMap.getOrDefault(key, 0) > 0) {
                            countMap.put(key, countMap.get(key) - 1);
                            if (countMap.get(key) == 0) countMap.remove(key);
                            break;
                        }
                    }
                }
            }

            while (!minHeap.isEmpty() && !countMap.containsKey(minHeap.peek())) minHeap.poll();
            while (!maxHeap.isEmpty() && !countMap.containsKey(maxHeap.peek())) maxHeap.poll();

            if (countMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
