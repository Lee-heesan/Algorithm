
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> [] list; 
	static int [] D;
	static boolean [] visited;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i =1 ; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
		}
		
		D = new int[N+1];
		for(int i=1; i<=N; i++) {
			visited= new boolean[N+1];
			
			visited[i] =true;
			D[i]++;
			queue.add(i);
			
			bfs();
		}
		
		
		int maxCount = 0;
		for (int i = 1; i <= N; i++) {
			maxCount = Math.max(maxCount, D[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (D[i] == maxCount) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
		
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			int now = queue.remove();
			
			for(int i : list[now]) {
				if(!visited[i]) {
					D[i]++;
					visited[i]=true;
					queue.add(i);
				}
			}
		}
	}
}