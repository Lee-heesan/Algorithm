import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		String N1 = sc.nextLine();
		String N2 = sc.nextLine();
		
		char[] N2_1 = N2.toCharArray();
		
		for(int i =2; i>=0;i--) {
			System.out.println(Integer.parseInt(N1)*Character.getNumericValue(N2_1[i]));
		}
		System.out.println(Integer.parseInt(N1)*Integer.parseInt(N2));
	}

}
