import java.io.*;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];
		for(int i = 0; i <= n; i++) {
			arr[i][0] = 1; // i 개에서 1개도 선택하지 않는 경우의 수는 0개 
			arr[i][i] = 1; // i 개에서 모두 선택하는 경우의 수는 1개 
			arr[i][1] = i; // i 개에서 1개 선택 경우의 수는 i개 
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j < i; j++) { // 고르는 수의 개수가 전체 개수를 넘을 수 없음 
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]; // 조합 점화식 
			}
		}		
		System.out.println(arr[n][k]);
	}
}
