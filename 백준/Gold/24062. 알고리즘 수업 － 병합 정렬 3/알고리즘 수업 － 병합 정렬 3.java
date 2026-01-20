import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] tmp;
    static int[] target;
    static int result = 0;
    static int mismatchCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        tmp = new int[N];
        target = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] != target[i]) {
            	mismatchCount++;
            }
        }
        
        if (mismatchCount == 0) {
            System.out.println(1);
            return;
        }

        merge_sort(arr, 0, N - 1);

        System.out.println(result);
    }

    static void merge_sort(int[] arr, int start, int end) {
        if (start >= end || result == 1) return;

        int mid = start + (end - start) / 2;
        merge_sort(arr, start, mid);
        merge_sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = start;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
            	tmp[t++] = arr[i++];
            }else {
            	tmp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
        	tmp[t++] = arr[i++];
        }
        while (j <= end) {
        	tmp[t++] = arr[j++];
        }

        for (int k = start; k <= end; k++) {
            if (arr[k] != target[k]) {
            	mismatchCount--;
            }

            arr[k] = tmp[k];

            if (arr[k] != target[k]) {
            	mismatchCount++;
            }

            if (mismatchCount == 0) {
                result = 1;
                return;
            }
        }
    }
}
