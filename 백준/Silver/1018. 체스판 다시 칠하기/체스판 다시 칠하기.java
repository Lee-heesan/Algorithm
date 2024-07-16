import java.util.Scanner;

public class Main {

	public static boolean [][] arr;
	public static int min = 64;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			
			// W 는 true , B 는 false
			for (int j = 0; j < str.length(); j++) {
				arr[i][j]= str.charAt(j)=='W' ? true :false ; 
			}
		}
		
		int N_row = N - 7;
		int M_col = M - 7;
		
		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);

	}
	
	public static void find(int x , int y) {
		boolean TF = arr[x][y];
		int count = 0;
		
		for(int i = x ; i<x+8;i++) {
			for(int j =y; j<y+8;j++) {
				
				if(arr[i][j]!=TF) {
					count++;
				}
				TF=!TF;
			}
			TF=!TF;
		}
		// count 중 W,F 중 적은 거 그리고 전의 min 와 비교하여 적은 거가 min
		min = Math.min(min, Math.min(count, 64-count));
	}

}