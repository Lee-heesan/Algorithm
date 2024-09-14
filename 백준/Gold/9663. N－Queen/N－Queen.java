import java.util.Scanner;

public class Main {
	
	static int count = 0; 
	static int N;
	static int[] queen;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		queen = new int[N];
		NQueen(0);
		System.out.println(count);
		
	}
	
	private static void NQueen(int depth) {
		if(depth==N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			queen[depth]=i;	
			if(isSafe(depth)) {
				NQueen(depth+1);
			}
		}
	}
	
	private static boolean isSafe(int col) {
		for(int i=0; i<col;i++) {
			if(queen[i]==queen[col]||Math.abs(queen[i]-queen[col])==Math.abs(i-col)) {
				return false;
			}
		}
		return true;
	}

}
