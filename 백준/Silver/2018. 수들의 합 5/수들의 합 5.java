import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int endIdx = 1;
		int startIdx =1;
		int count =1;
		int sum = 1;
		
		while(endIdx!=N) {
			 if(sum==N) {
				 count++;
				 sum+=(++endIdx);
			 }else if(sum>N) {
				 sum-=(startIdx++);
			 }else if(sum<N) {
				 sum+=(++endIdx);
			 }
		}	
		System.out.println(count);
	}

}
