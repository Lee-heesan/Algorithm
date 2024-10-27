
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static PriorityQueue<Integer> PQ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PQ = new PriorityQueue<Integer>();
		
		for(int i = 0; i<N; i++) {
			PQ.add(sc.nextInt());
		}
		
		
		int total = 0;
		while(PQ.size()!=1) {
			int num1 = PQ.remove();
			int num2 = PQ.remove();
			total += num1 + num2;
			PQ.add(num1+num2);
		}
		
		System.out.print(total);

	}

}
