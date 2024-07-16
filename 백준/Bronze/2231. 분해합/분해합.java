import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int result=0;
		
		for (int i =0; i<N;i++) {
			int number =i;
			int sum=i;
			while(number!=0) {
				sum+=number%10;
				number/=10;
			}
			if(N==sum) {
				result=i;
				break;
			}
		}
		System.out.println(result);
	}

}
