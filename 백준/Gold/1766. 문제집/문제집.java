import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int [] indegree; // 특정 정점에 들어오는 간선의 개수
	static int N,M,A,B;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [] indegree = new int[N+1];
		list = new ArrayList<>();
		for(int i =0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			list.get(A).add(B);
			indegree[B]++;
		}
		
		// 2. 먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i =1; i<=N; i++) {
			if(indegree[i] == 0) {
				pq.offer(i);
			}
		}
		
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now + " ");
			
			for(int next : list.get(now)) {
				
				indegree[next]--;
				
				//먼저 풀어야하는 문제가 없는 경우 새롭게 큐에 데이터를 집어 넣는다.
				if(indegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
		
		
		System.out.println(sb.toString());
	}

}
