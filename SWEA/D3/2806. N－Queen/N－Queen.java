import java.util.Scanner;

class Solution
{
		public static int N;
		public static int  [] queens;
		public static int count;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++) {
			N = sc.nextInt();
			queens= new int [N];
			count=0;
			queen(0);
			sb.append("#").append(i+1).append(" "+count).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
	public static void queen(int depth) {
		if(depth==N) {
			count++;
			return;
		}
		
		for(int i=0; i<N;i++) {
			queens[depth]=i;
			if(isSafe(depth)) {
				queen(depth+1);
			}
		}
	}
	
	public static boolean isSafe(int col) {
		for(int i =0; i<col;i++) {
			if(queens[i]==queens[col]||Math.abs(queens[i] - queens[col]) == Math.abs(i - col)) {
				return false;	
			}
		}
		
		return true;
	}

}
