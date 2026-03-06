import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);

        int left = 0;
        int right = sumB.size() - 1;
        long count = 0;

        while (left < sumA.size() && right >= 0) {
            int sum = sumA.get(left) + sumB.get(right);

            if (sum == T) {
                int a = sumA.get(left);
                int b = sumB.get(right);

                long leftCount = 0;
                long rightCount = 0;

                //같은 수 세기
                while (left < sumA.size() && sumA.get(left) == a) {
                    leftCount++;
                    left++;
                }

                while (right >= 0 && sumB.get(right) == b) {
                    rightCount++;
                    right--;
                }

                count += leftCount * rightCount;
            } else if (sum < T) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}