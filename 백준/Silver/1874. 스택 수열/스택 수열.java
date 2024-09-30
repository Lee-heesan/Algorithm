import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		
		int N = sc.nextInt();
		
		int lastNum = 1;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i =0; i<N; i++) {
			int num = sc.nextInt();
			if(lastNum<=num) {
				while(lastNum<=num) {
					stack.push(lastNum++);
					sb.append("+\n");
				}
			}else if(stack.peek()!=num) {
				System.out.println("NO");
                return;
			}
			stack.pop();
			sb.append("-\n");
		}
		
		System.out.println(sb.toString());

	}

}
