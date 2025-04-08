import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;
	static thing [] arr;
	static class thing{
		int V;
		int C;
		
		public thing(int V, int C) {
			this.V = V;
			this.C = C;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
				
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new thing[N+1];
			for(int j=1; j<=N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j] = new thing(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			int dp[][] = new int[N+1][K+1];
			
            for(int k=1; k<=N; k++){
                for(int j=1; j<=K; j++){
                    if(arr[k].V > j){
                        dp[k][j] = dp[k-1][j];
                    }else{
                        dp[k][j] = Math.max(dp[k - 1][j - arr[k].V] + arr[k].C,
                                dp[k - 1][j]);
                    }
                }
            }

			sb.append("#"+ i + " "+ dp[N][K]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
