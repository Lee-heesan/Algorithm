
import java.util.Scanner;

class Solution
{
	public static void main(String args[])throws Exception{
		Scanner sc = new Scanner(System.in);
		
		for(int i =1; i<=10; i++) {
			int seq = sc.nextInt();
			long N = sc.nextLong();
			int M = sc.nextInt(); 			
			long result= pow(N,N,M-1);


			System.out.println("#"+seq+" "+result);
		}

	}
	
	
	public static long pow(long now ,long N, int M) {
		if(M==0) {
			return now;
		}
		return pow(now*N,N,M-1);
	}

}
