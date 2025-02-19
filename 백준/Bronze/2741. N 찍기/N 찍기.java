import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N  = sc.nextInt();
		
		for(int i =1; i<=N; i++) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
