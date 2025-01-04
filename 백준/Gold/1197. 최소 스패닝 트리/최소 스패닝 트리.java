import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<pEdge> queue;
	static int [] parent;
	static class pEdge implements Comparable<pEdge>{
		int s;
		int e; 
		int v;
		
		pEdge(int s, int e, int v){
			this.s = s;
			this.e = e;
			this.v = v;
		}
		
		
		@Override
		public int compareTo(pEdge o) {
			return this.v - o.v;
		}
		
		
	}
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		queue = new PriorityQueue<>();
		parent = new int[V+1];
		for(int i =0; i<=V; i++) {
			parent[i]=i;
		}
		
		for(int i =1; i<=E; i++) {
			st= new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			queue.add(new pEdge(A, B, C));
		}
		
		int useEdge = 0;
		int result = 0;
		while(useEdge <V-1) {
			pEdge now = queue.poll();
			if(find(now.s) != find(now.e)) {
				union(now.s , now.e);
				result += now.v;
				useEdge++;
			}
		}
		
		System.out.println(result);
	
	}
	
	
	public static void union(int A , int B) {
		int rootA = find(A);
		int rootB = find(B);
		
		if(rootA != rootB) {
			parent[rootA] = rootB;
		}
	}
	
	
	public static int find(int n) {
		if(parent[n]==n) {
			return n; 
		}
		
		return parent[n] = find(parent[n]);
	}

}
