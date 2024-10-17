
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> [] list ;
	static boolean [] visited;
	static StringBuilder sb;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = new Stack[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i<=N; i++) {
			list[i] = new Stack<Integer>();
		}
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		for(int i =1; i<=N; i++) {
			list[i].sort(null);
		}
		
		
		sb = new StringBuilder();
		System.out.println(DFS(V));
		visited = new boolean[N+1];
		System.out.println(BFS(V));
		
		
	}
	
	public static String BFS(int num) {
		sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(num);
		sb.append(num +" ");
		visited[num]=true;
		
		while(!q.isEmpty()) {
			int tmp = q.remove();
			
			for(int i =0 ; i<list[tmp].size(); i++) {
				if(visited[list[tmp].get(i)]) {
					continue;
				}
				q.offer(list[tmp].get(i));
				visited[list[tmp].get(i)]=true;
				sb.append(list[tmp].get(i)+" ");
			}
		}
		
		return sb.toString();
	}
	
	public static String DFS(int num) {
		sb.append(num+" ");
		if(list[num].isEmpty()) {
			return sb.toString();
		}
		
		visited[num]= true;
	
		for(int i = 0; i<list[num].size(); i++) {
			int to = list[num].get(i);
			if(visited[to]) {
				continue;
			}
			DFS(to);
		}
		
		
		return sb.toString();
	}

}
