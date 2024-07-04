import java.util.Scanner;
import java.lang.Math;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int A = sc.nextInt();
		int p=2;
		
		for(int i=0; i<A;i++) {
		  p += (int) Math.pow(2, i);
		}
		int sum = p*p;
		System.out.println(sum);
	}

}
