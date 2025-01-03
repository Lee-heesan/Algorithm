
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long [][] D;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		D = new long[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				D[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		//플로이드 
		for(int m = 1; m<=N; m++) {
			for(int s=1; s<=N; s++) {
				for(int e=1; e<=N; e++) {
					if (D[s][m] == 1 && D[m][e] == 1) {
                        D[s][e] = 1;
                    }
				}
			}
		}
		
		
		for(int i =1; i<=N; i++) {
			for(int j =1; j<=N; j++) {
				sb.append(D[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString());

	}

}
