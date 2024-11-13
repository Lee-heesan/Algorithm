import java.io.*;
import java.util.StringTokenizer;

class Solution
{
	static int N;
	static long P;
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
	
		for(int i=1; i<=T; i++) {
			st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());	

			sb.append(dfs(0,0)+"\n");
		}
		
		System.out.println(sb);
	}
	
	
	public static int dfs(int now , int depth) {
		if(depth == N) {
			return now; 
		}
		
		
		if(now+(depth+1)==P) {
			return dfs(now+depth,depth+1);
		}else{
			return dfs(now+(depth+1),depth+1);	
		}
	}
}