import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<node> [] list;
	static int [] D;
	static PriorityQueue<Integer> [] dis;
	static class node implements Comparable<node>{
		int E;
		int D;
		
		node(int E, int D){
			this.E = E;
			this.D = D;
		}
		
		@Override
		public int compareTo(node o) {
			return this.D-o.D;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList[n+1];
		dis = new PriorityQueue[n+1];
		D = new int[n+1];
		for(int i =1; i<=n; i++) {
			list[i]=new ArrayList<node>();
			dis[i]= new PriorityQueue<Integer>(Collections.reverseOrder());
		}
		
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new node(b,c));
		}
		
		
		PriorityQueue<node> PQ = new PriorityQueue<node>();
		PQ.add(new node(1,0));
		dis[1].add(0);
		while(!PQ.isEmpty()) {
			node now = PQ.poll();
			
			for(node nxt : list[now.E]) {
				if(dis[nxt.E].size()<k) {
					dis[nxt.E].add((now.D+nxt.D));
					PQ.add(new node(nxt.E, now.D+nxt.D));
				}else if(dis[nxt.E].peek()>now.D+nxt.D) {
					dis[nxt.E].poll();
					dis[nxt.E].add(now.D+nxt.D);
					PQ.add(new node(nxt.E, now.D+nxt.D));
				}
			}
		}
		
		
		for (int i = 1; i < n+1; ++i){
			if (dis[i].size() == k) {
				sb.append(dis[i].peek()+"\n");
			}
			else {
				sb.append(-1+"\n");
			}
		}
		
		
		System.out.println(sb.toString());
	}

}
