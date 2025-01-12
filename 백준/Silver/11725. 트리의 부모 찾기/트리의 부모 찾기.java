import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> [] list ;
	static int N;
	static boolean [] visited;
	static int [] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		for(int i =1; i<=N; i++) {
			list[i]=new ArrayList<Integer>();
			parent[i]= 0;
		}
		
		for(int i =1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int Node1 = Integer.parseInt(st.nextToken());
			int Node2 = Integer.parseInt(st.nextToken());
			
			list[Node1].add(Node2);
			list[Node2].add(Node1);
		}
		
		DFS(1);
		for(int i =2; i<=N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void DFS(int num) {
		visited[num]= true;
		for(int i : list[num]) {
			if(!visited[i]) {
				parent[i]=num;
				DFS(i);
			}
		}
	}

}
