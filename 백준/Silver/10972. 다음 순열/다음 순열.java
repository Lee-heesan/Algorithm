import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(arr)) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }
    }

    // nextPermutation 구현
    private static boolean nextPermutation(int[] arr) {
        int N = arr.length;

        // 1. 뒤에서부터 처음으로 감소하는 지점 찾기
        int i = N - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // 만약 i가 음수라면, 마지막 순열이므로 -1 반환
        if (i < 0) {
            return false;
        }

        // 2. arr[i]보다 큰 값 중 가장 오른쪽 값을 찾기
        int j = N - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }

        // 3. arr[i]와 arr[j] 스왑
        swap(arr, i, j);

        // 4. arr[i+1]부터 끝까지를 오름차순 정렬 (반대로 뒤집기)
        reverse(arr, i + 1, N - 1);

        return true;
    }

    // 배열 스왑 함수
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 배열 구간 뒤집기 함수
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
