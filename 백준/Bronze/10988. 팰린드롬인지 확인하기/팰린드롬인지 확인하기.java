import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.nextLine();
		String B = new StringBuilder().append(A).reverse().toString();
		
		if(A.equals(B)) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}

}
