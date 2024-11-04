
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> [] list;
	static boolean [] visited;
	static int [] count; 
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		count = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
		}
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			
			visited[i]=true;
			count[i]++;
			DFS(i);
		}
		
		int maxCount =0;
		for(int i=1; i<=N; i++) {
			maxCount = Math.max(maxCount, count[i]);
		}
		
		for(int i =1; i<=N; i++) {
			if(maxCount==count[i]) {
				sb.append(i+" ");
			}
		}
		
		System.out.println(sb);
	}
	
	public static void DFS(int num) {
		for(int i: list[num]) {
			if(!visited[i]) {
				visited[i]=true;
				count[i]++;
				DFS(i);
			}
		}
	}

}
