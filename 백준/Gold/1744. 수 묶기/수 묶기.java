
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> positive;
    static List<Integer> negative;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        positive = new LinkedList<>();
        negative = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        // 양수는 큰 값부터 곱할 수 있게 내림차순 정렬
        positive.sort((o1, o2) -> o2 - o1);
        // 음수는 작은 값부터 곱할 수 있게 오름차순 정렬
        Collections.sort(negative);

        int sum = 0;

        // 양수 리스트에서 큰 값부터 곱하여 최대합 구하기
        while (positive.size() > 1) {
            int num1 = positive.remove(0); // 첫 번째 요소부터 꺼내기
            int num2 = positive.remove(0);
            sum += Math.max(num1 * num2, num1 + num2);
        }

        if (!positive.isEmpty()) {
            sum += positive.remove(0);
        }

        // 음수 리스트에서 작은 값부터 곱하여 최대합 구하기
        while (negative.size() > 1) {
            int num1 = negative.remove(0);
            int num2 = negative.remove(0);
            sum += num1 * num2;
        }

        // 음수 리스트에 남은 값이 0이 아니면 더하기
        if (!negative.isEmpty() && negative.get(0) != 0) {
            sum += negative.remove(0);
        }

        System.out.println(sum);
    }
}
