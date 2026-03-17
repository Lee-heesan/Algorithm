import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] indegree;
	static List<Integer> [] list;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int [N+1];
		list = new LinkedList [N+1];
		
		for(int i = 1; i<=N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			indegree[B]++;
			list[A].add(B);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = N; i>=1; i--) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now+" ");
			
			for(int next : list[now]) {
				indegree[next]--;
				
				if(indegree[next]==0) {
					queue.add(next);
				}
			}
		}
		
		
		System.out.println(sb.toString());		
	}
}
