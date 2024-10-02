
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		int N = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                	// 절대값은 같을 때 작은 수
                	return o1 - o2;
                }
                else {
                	return Math.abs(o1) - Math.abs(o2);
                }
            }
        });
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(queue.isEmpty()) sb.append("0").append("\n");
				else sb.append(queue.poll()).append("\n");
			}else {
				queue.add(x);
			}
		}
		System.out.println(sb.toString());
	}
}
