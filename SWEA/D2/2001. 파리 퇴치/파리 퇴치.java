import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{	
    static int [][] C;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			C = new int[N+1][N+1];
			for(int j=1; j<N+1; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=1; k<N+1; k++) {
					C[j][k] = C[j][k-1]+C[j-1][k]-C[j-1][k-1]+Integer.parseInt(st.nextToken());
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			for(int j=M;j<N+1;j++) {
				for(int k = M; k<N+1;k++) {
					int sum = C[j][k]-C[j-M][k]-C[j][k-M]+C[j-M][k-M];
					max = Math.max(max,sum );
				}
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);

	}

}
