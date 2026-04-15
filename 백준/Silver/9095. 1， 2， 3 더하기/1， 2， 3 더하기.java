import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int count;
	public static void main(String[] args) throws IOException{
		Scanner sc =new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int i =0; i<T; i++) {
			int num = sc.nextInt();
			count = 0;
			cal(num);
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void cal(int num) {
		if(num==0) {
			count++;
			return;
		}
		
		
		for(int i = 1; i<=3; i++) {
			int now = num -i;
			
			if(now>=0) {
				cal(now);
			}
		}
	}
}
