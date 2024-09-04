
import java.util.Scanner;

public class Main {
		static char[] A;
		static char[] B;
		static int [][] dp;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		int alength = a.length();
		int blength = b.length();
		
		A = new char[alength + 1];
		B = new char[blength + 1];
		
		for(int i = 1; i <= alength; i++) {
			A[i] = a.charAt(i - 1);
		}
		for(int i = 1; i <= blength; i++) {
			B[i] = b.charAt(i - 1);
		}
		
		
		dp = new int[B.length][A.length];

		for(int i = 1; i <= blength; i++) {
			for(int j = 1; j <= alength; j++) {
				// 만일 두 문자가 같은 경우
				if(B[i] == A[j]) {
					// 대각선의 값을 참고하여 LCS의 값을 + 1한다.
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				// 두 문자가 다른 경우
				else {
					// 각 문자열의 이전 문자 중 최대 LCS값을 선택.
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		System.out.println(dp[blength][alength]);
	}
}
