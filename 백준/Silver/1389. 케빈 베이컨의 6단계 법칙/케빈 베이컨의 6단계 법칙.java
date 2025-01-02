import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int [][] D;
	static int kevinNum = 9_999;
	static int result= 0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		D = new int [N+1][N+1];
	    for (int i = 1; i <= N; i++) {
	            Arrays.fill(D[i], 9_9999);
	            D[i][0] = 0;
	            D[i][i] = 0;
	    }
		
		for(int i =1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			D[s][e] = 1;
			D[e][s] = 1;
		}
		
		//플로이드
		for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    D[s][e] = Math.min(D[s][e], D[s][m] + D[m][e]);
                }
            }
        }
		
		
		for (int i = 1; i <= N; i++) {
	            for (int j = 1; j <= N; j++) {
	                if (D[i][j] != 9_999) {
	                    D[i][0] += D[i][j];
	                }
	            }
	            if (kevinNum > D[i][0]) {
	                kevinNum = D[i][0];
	                result = i;
	            }
	     }
		
		System.out.println(result);
	}

}
