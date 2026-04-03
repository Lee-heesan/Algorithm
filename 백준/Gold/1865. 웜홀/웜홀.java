import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge{
		int start;
		int end;
		int distance;
		
		public Edge(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();	
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < TC ; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			List<Edge> edges = new ArrayList<>();
			
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edges.add(new Edge(S,E,T));
				edges.add(new Edge(E,S,T));
			}
			
			for(int j = 0; j<W; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edges.add(new Edge(S,E,-T));
			}
			
			boolean hasNegativeCycle = bellmanFord(N, edges);
	        sb.append(hasNegativeCycle ? "YES" : "NO").append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean bellmanFord(int N, List<Edge> edges) {
		 int[] dist = new int[N + 1];
		 
		 Arrays.fill(dist, 0);
		 
		 for(int i=1; i<=N; i++) {
			 boolean isUpdate = false;
			 
			 for(Edge now : edges) {
				 if(dist[now.end]>dist[now.start]+now.distance) {
					 dist[now.end]=dist[now.start]+now.distance;
					 isUpdate = true;

					 if (i == N) {
	                    return true;
	                 }
				 }
			 }
			 
			 if(!isUpdate) {
				 break;
			 }	
		 }
	     
		return false;
	}
}
