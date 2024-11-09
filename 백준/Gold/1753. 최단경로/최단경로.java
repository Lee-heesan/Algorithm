
import java.io.*;
import java.util.*;

public class Main {
	// 1753 다익스트라
	static List<Node> [] list;
	static int [] D;
	static boolean [] visited;
	static int V,E,start;
	static int u,v,w;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		D = new int[V+1];
		visited = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i]= new ArrayList<>();
			D[i]=Integer.MAX_VALUE;
		}
		
		start = Integer.parseInt(br.readLine());
		D[start] =0;
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v,w));
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start,0));
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(visited[now.E]) continue;
			visited[now.E]=true;
			
			
			for(Node next: list[now.E] ) {
				if(D[next.E]>D[now.E]+next.D) {
					D[next.E] = D[now.E]+next.D;
					queue.add(new Node(next.E,D[next.E]));
				}
			}
		}
		
		for(int i=1; i<=V;i++) {
			if(!visited[i]) {
				sb.append("INF"+"\n");
				continue;
			}
			sb.append(D[i]+"\n");
		}
		
		System.out.println(sb);
		
	}
	
	
	static class Node implements Comparable<Node>{
		int E;
		int D;
		
		public Node(int E, int D) {
			this.E = E;
			this.D = D;
		}

		@Override
		public int compareTo(Node e) {
			if(this.D>e.D) return 1;
			else return -1;
		}
		
	}
}