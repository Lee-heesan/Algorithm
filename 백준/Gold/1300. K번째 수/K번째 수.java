import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		long lo = 1;
		long hi = k;
		
		while(lo<hi) {
			long mid = (lo+hi)/2;
			long count =0;
			
			
			for(int i =1; i<=N; i++) {
				// lower Bound 방식
				count +=Math.min(mid/i, N);
					}
			
			if (k>count) {
				lo = mid+1;
			}else {
				hi = mid;
			}
		}
		
		System.out.println(lo);
	}

}
