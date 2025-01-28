
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static int size;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // n, m, k 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        size = 1;
        while (size < n) {
            size *= 2;
        }
        tree = new long[size * 2];

        // 트리 초기화
        for (int i = size; i < size + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        build(); // 트리 구성

        // 쿼리 처리
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(size + b - 1, c); // b번째 값을 c로 갱신
            } else if (a == 2) {
                sb.append(query(size + b - 1, size + (int) c - 1)).append("\n"); // b부터 c까지 곱셈 쿼리
            }
        }

        System.out.println(sb.toString());
    }

    // 구간 곱셈 쿼리
    private static long query(int start, int end) {
        long paramSum = 1;

        while (start <= end) {
            if (start % 2 == 1) { // start가 오른쪽 자식이면 해당 값 포함
                paramSum = (paramSum * tree[start]) % 1000000007; // 곱셈 후 모듈러 연산
                start++;
            }
            if (end % 2 == 0) { // end가 왼쪽 자식이면 해당 값 포함
                paramSum = (paramSum * tree[end]) % 1000000007;
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return paramSum;
    }

    // 업데이트 함수
    private static void update(int idx, long value) {
        tree[idx] = value;

        // 업데이트된 값을 부모까지 전파
        while (idx > 1) {
            idx /= 2;
            tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % 1000000007; // 곱셈 후 모듈러 연산
        }
    }

    // 트리 초기화
    private static void build() {
        for (int i = size - 1; i > 0; i--) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % 1000000007; // 곱셈 후 모듈러 연산
        }
    }
}
