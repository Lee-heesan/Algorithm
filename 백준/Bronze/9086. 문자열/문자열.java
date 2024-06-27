import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		String A [] = new String[num];
		for(int i =0; i<num; i++) {
			A[i]=sc.next();
			A[i]=A[i].substring(0,1)+A[i].substring(A[i].length()-1,A[i].length());
		}
		
		for(int j=0; j<num;j++) {
			System.out.println(A[j]);
		}

	}

}
