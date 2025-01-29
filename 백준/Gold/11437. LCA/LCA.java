import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 일반 최소 공통 조상 구하기
	static List<Integer> [] list;
	static int [] parent;
	static int [] depth;
	static boolean [] visited;
	static int N,M;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList [N+1];
		parent = new int[N+1]; 
		for(int i =1; i<=N ; i++) {
			list[i] = new ArrayList<Integer>();
			parent[i] = i;
		}
		depth = new int[N+1];
		visited = new boolean[N+1];
		
		// 트리 구성
		for(int i = 0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		// 초기화(노드 부모,  노드 깊이 설정)
		BFS(1);
		
		// 최소 공통 조상 구하기
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int LCA = excuteCA(a,b);
			sb.append(LCA).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	private static int excuteCA(int a, int b) {
		// b의 깊이가 큰 수로
		if(depth[a]>depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
//		int aDepth = depth[a];
//		int bDepth = depth[b];
		
		// 깊이 같도록
		while(depth[a] < depth[b]) {  
		    b = parent[b];
		}
		
		// 깊이가 같은 상태에서 부모를 찾음
		while (a != b) {  
		    a = parent[a];
		    b = parent[b];
		}
		return a;

	}
	
	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		depth[start] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : list[now]) {
				if(visited[next]) {
					continue;
				}
				depth[next] = depth[now]+1;
				visited[next] = true;
				parent[next] = now;
				q.add(next);
			}
		}
	}

}
