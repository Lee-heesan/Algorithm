
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.*;

public class Main {
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb =  new StringBuilder();
		
		int [][] arr = new int [31][31];
		for(int i =0; i<arr.length; i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
			arr[i][1] = i;
		}
		
		for(int i =2; i<arr.length; i++) {
			for(int j = 1; j<i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				
//				System.out.println("arr["+i+"]["+j+"] = "+ arr[i][j]);
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(k>n) {
				int temp = k;
				k = n;
				n = temp;
			}
			
			sb.append(arr[n][k]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
