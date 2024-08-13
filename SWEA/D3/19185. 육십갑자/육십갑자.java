import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		// 1. 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<T ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			String [] NList = br.readLine().split(" ");
			String [] MList = br.readLine().split(" ");
			
			int Q = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < Q; j++) {
	               int Y = Integer.parseInt(br.readLine());
	               sb.append(NList[(Y % N - 1 + N) % N]).append(MList[(Y % M - 1 + M) % M]);
	               if (j < Q - 1) {
	                   sb.append(" ");
	               }
	        }
			System.out.println("#"+(i+1)+" "+sb.toString());
			
		}
	
	}

}
