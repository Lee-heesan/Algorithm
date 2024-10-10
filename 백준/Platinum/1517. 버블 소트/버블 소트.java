import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static long[] sorted;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        arr = new long[N];
        sorted = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, N - 1);

        System.out.println(count);
    }

    public static void merge_sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 재귀적으로 분할
            merge_sort(left, mid);
            merge_sort(mid + 1, right);

            // 병합
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int low = left;
        int high = mid + 1;
        int idx = left;

        // 병합 작업
        while (low <= mid && high <= right) {
            if (arr[low] <= arr[high]) {
                sorted[idx++] = arr[low++];
            } else {
                sorted[idx++] = arr[high++];
                count += (mid + 1 - low);  // 역전 횟수 증가
            }
        }

        // 남은 부분 처리
        while (low <= mid) {
            sorted[idx++] = arr[low++];
        }

        while (high <= right) {
            sorted[idx++] = arr[high++];
        }

        // 정렬된 배열 복사
        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
