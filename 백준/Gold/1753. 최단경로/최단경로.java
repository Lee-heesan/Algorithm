import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<Node> [] list; 
	static int [] D;
	static boolean [] visited;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		
		visited = new boolean[V+1];
		D = new int [V+1];
		list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			D[i] = Integer.MAX_VALUE;
			list[i] = new ArrayList<Node>();
			
			if(S==i) {
				D[i]=0;
			}
		}
		
		
		for(int i =0; i<E; i++) {
			st= new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v,w));
		}
		
		
		PriorityQueue<Node> PQ = new PriorityQueue<Node>();
		PQ.add(new Node(S,0));
		while(!PQ.isEmpty()) {
			Node now = PQ.poll();
			
			if(visited[now.E]) continue;
			visited[now.E] = true;
			
			for(Node next : list[now.E]){
				if(next.D+D[now.E]<D[next.E]) {
					D[next.E]=next.D+D[now.E];
					PQ.add(new Node(next.E,D[next.E]));
				}
			}
		}
		
		
		
		for(int i=1; i<=V; i++) {
			if(!visited[i]) {
				sb.append("INF"+"\n");
				continue;
			}
			sb.append(D[i]).append("\n");
		}
		
		
		System.out.println(sb.toString());
		
		
	}
	
	static class Node implements Comparable<Node>{
		int E;
		int D;
		
		Node(int E, int D){
			this.E = E;
			this.D = D;
		}

		@Override
		public int compareTo(Node o) {
			if(this.D>o.D) {
				return 1;
			}else {
				return -1;
			}
		}
	}

}
