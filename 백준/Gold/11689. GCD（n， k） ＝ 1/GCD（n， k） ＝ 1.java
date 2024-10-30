
import java.util.Scanner;

public class Main {
	static long [] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Long N = sc.nextLong();
		long temp = N;
		for (long i=2; i<=Math.sqrt(N); i++) {
			if (N%i == 0) {
				temp = temp - (temp/i);
				while (N%i == 0) {
					N /= i;
				}
			}
		}
		if (N > 1) {
			temp = temp - (temp/N);
		}
		System.out.println(temp);
		
		
	
	}

}
