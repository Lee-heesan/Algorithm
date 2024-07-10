import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int first = sc.nextInt();
		int last  = sc.nextInt();
		
		int sum =0;
		int min =0;
		for(int i =first; i<=last; i++) {
			int count = 0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2) {
				sum+=i;
				if(sum==i) {
					min=i;
				}
			}
		}
		if(sum==0&&min==0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
