import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr;
	static int [][] copy;
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i =1 ; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			
			arr = new int[n][n];
			copy = new int[n][n];
			for(int j =0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					copy[j][k] =arr[j][k];
				}
			}
			
			int repeat = ((d%360)/45);
			
			
			
			if(repeat>0) {
				for(int j=0; j<repeat; j++) {
					for(int k = 0; k < n ; k++){
			            copy[k][n/2] = arr[k][k];
			            copy[k][k] = arr[n/2][k];
			            copy[n/2][k] = arr[n-k-1][k];
			            copy[n-k-1][k] = arr[n-k-1][n/2];
			      }
					for(int k = 0; k < n ; k++){
						 for(int p =0; p<n; p++) {
							 arr[k][p] = copy[k][p];
						 }
				      }
				}
			}else if(repeat<0) {
				repeat = Math.abs(repeat);
				for(int j=0; j<repeat; j++) {
					 for(int k = 0; k < n ; k++){
						 copy[k][k] = arr[k][n/2];
						 copy[n/2][k] = arr[k][k];
						 copy[n-k-1][k] = arr[n/2][k];
						 copy[n-k-1][n/2] = arr[n-k-1][k];
				      }
					 
					 
					 for(int k = 0; k < n ; k++){
						 for(int p =0; p<n; p++) {
							 arr[k][p] = copy[k][p];
						 }
				      }
				}
			}
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					sb.append(arr[j][k]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
