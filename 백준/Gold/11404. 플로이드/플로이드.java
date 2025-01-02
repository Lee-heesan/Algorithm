import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static long [][] D;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		D = new long[n+1][n+1];
		
		for(int i =1; i<=n; i++) {
		    Arrays.fill(D[i], 9_999_999);
		    D[i][i]= 0;
		}

		
		for(int i =0; i<m; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    D[a][b] = Math.min(D[a][b], c);
		}

		
		//폴로이드
		for(int m = 1; m<=n; m++) {
		    for(int s = 1; s<=n; s++) {
		        for(int e =1; e<=n; e++) {
		            D[s][e]= Math.min(D[s][e], D[s][m]+D[m][e]);
		        }
		    }
		}

		
		//output
		for(int i =1; i<=n; i++) {
			for(int j =1; j<=n; j++) {
				long tmp = D[i][j];
				if(tmp == 9_999_999) {
					sb.append("0").append(" ");
				}else {
					sb.append(tmp).append(" ");
				}
			}
			sb.append("\n");
		}	
		
		
		System.out.println(sb.toString());
	}

}
