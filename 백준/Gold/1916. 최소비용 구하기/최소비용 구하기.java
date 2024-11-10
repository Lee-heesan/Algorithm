import java.io.*;
import java.util.*;

public class Main {
	// 1916  다익스트라
	static List<Node> [] list;
	static int [] D;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visited = new boolean [N+1];
		D = new int[N+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		for(int i=1; i<=N; i++) {
			list[i]= new ArrayList<>();
		}
		
		for(int i =0 ; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			int SCity = Integer.parseInt(st.nextToken());
			int ECity = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			
			list[SCity].add(new Node(ECity,F));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		D[start] =0;
		
		PriorityQueue<Node> PQ = new PriorityQueue<>();
		PQ.add(new Node(start,0));
		
		while(!PQ.isEmpty()) {
			Node now = PQ.poll();
			 
			if(!visited[now.city]) {
				visited[now.city]=true;
				for(Node next : list[now.city] ) {
					if(now.fee+next.fee<D[next.city]) {
						D[next.city] = now.fee+next.fee;
						PQ.add(new Node(next.city,D[next.city]));
					}
				}
			}
		}
			
		System.out.println(D[end]);
	
		
	}
	
	static class Node implements Comparable<Node>{
		int city;
		int fee;
		
		public Node(int city, int fee) {
			this.city = city;
			this.fee = fee;
		}

		@Override
		public int compareTo(Node o) {
			if(this.fee>o.fee) return 1;
			return -1;
		}
	}
}