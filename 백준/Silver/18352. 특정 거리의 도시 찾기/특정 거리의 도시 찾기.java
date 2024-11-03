
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> [] Q;
	static int N,M,K,X;
	static boolean [] visited;
	static PriorityQueue<Integer> result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		result = new PriorityQueue<Integer>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		Q = new LinkedList[N+1];
		visited = new boolean [N+1];
		for(int i=1; i<=N; i++) {
			Q[i]= new LinkedList<Integer>();
		}
		
		for(int i = 0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			Q[start].add(end);
		}
		
		BFS(X);
		
		if(result.isEmpty()) {
			System.out.println(-1);
			return;
		}
		
		while(!result.isEmpty()) {
			sb.append(result.remove()+"\n");
		}	
		
		System.out.println(sb.toString());
			
		
	}
	
	public static void BFS(int node) {
		Queue<int []> tmp = new LinkedList<>();
		tmp.add(new int[] {node,0});
		
		while(!tmp.isEmpty()) {
			int [] num = tmp.remove();
			
			if (!visited[num[0]]) {
				visited[num[0]]=true;
				
				
				if(num[1]== K) {
						result.add(num[0]);
				}else {
					while(!Q[num[0]].isEmpty()) {
						tmp.add(new int [] {Q[num[0]].remove(),num[1]+1});
					}
				}
			}
		}
	}

}
