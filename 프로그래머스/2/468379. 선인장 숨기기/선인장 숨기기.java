import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        int INF = 1_000_000_000;

        // 1️⃣ time 배열
        int[][] time = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(time[i], INF);
        }

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            time[r][c] = i + 1;
        }

        // 2️⃣ 가로 슬라이딩 최소 (w)
        int[][] rowMin = new int[m][n - w + 1];

        for (int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {

                // 윈도우 범위 벗어난 인덱스 제거
                while (!dq.isEmpty() && dq.peekFirst() <= j - w) {
                    dq.pollFirst();
                }

                // 현재 값보다 큰 값 제거
                while (!dq.isEmpty() && time[i][dq.peekLast()] >= time[i][j]) {
                    dq.pollLast();
                }

                dq.addLast(j);

                // 결과 기록
                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = time[i][dq.peekFirst()];
                }
            }
        }

        // 3️⃣ 세로 슬라이딩 최소 (h)
        int[][] finalMin = new int[m - h + 1][n - w + 1];

        for (int j = 0; j < n - w + 1; j++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {

                while (!dq.isEmpty() && dq.peekFirst() <= i - h) {
                    dq.pollFirst();
                }

                while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[i][j]) {
                    dq.pollLast();
                }

                dq.addLast(i);

                if (i >= h - 1) {
                    finalMin[i - h + 1][j] = rowMin[dq.peekFirst()][j];
                }
            }
        }

        // 4️⃣ max(min) 찾기 + tie-breaking
        int bestVal = -1;
        int ansR = 0, ansC = 0;

        for (int i = 0; i <= m - h; i++) {
            for (int j = 0; j <= n - w; j++) {
                int val = finalMin[i][j];

                if (val > bestVal) {
                    bestVal = val;
                    ansR = i;
                    ansC = j;
                }
            }
        }

        return new int[]{ansR, ansC};
    }
}