
import java.io.*;
import java.util.*;

public class Main {
	//2252 위상정렬
	static List<ArrayList<Integer>> list;
	static int D [];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		int [] indegree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list.get(S).add(E);
			indegree[E]++;
		}
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i =1; i<=N; i++) {
			if(indegree[i]==0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now+" ");
			for(int next : list.get(now)) {
				indegree[next]--;
				if(indegree[next]==0) {
					queue.offer(next);
				}
			}
		}
		
		System.out.println(sb);
	}
	
}
