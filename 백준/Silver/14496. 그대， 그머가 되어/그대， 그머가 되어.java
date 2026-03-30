import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int a,b;
	static int N,M;
	static List<Integer> [] list;
	static int answer = -1;
	static class node implements Comparable<node>{
		int n;
		int cnt;
		
		public node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(node n1) {
			return this.cnt - n1.cnt;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		bfs(a);
		System.out.println(answer);
	}
	
	public static void bfs(int start) {
	    PriorityQueue<node> PQ = new PriorityQueue<>();
	    PQ.add(new node(start, 0));
	    int[] dist = new int[N + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[start] = 0;

	    if (start == b) {
	        answer = 0;
	        return;
	    }

	    while (!PQ.isEmpty()) {
	        node now = PQ.poll();

	        for (int nxt : list[now.n]) {
	            if (nxt == b) {
	                answer = now.cnt + 1;
	                return;
	            }

	            if (dist[nxt] > now.cnt + 1) {
	                PQ.add(new node(nxt, now.cnt + 1));
	                dist[nxt] = now.cnt + 1;
	            }
	        }
	    }
	}

}
