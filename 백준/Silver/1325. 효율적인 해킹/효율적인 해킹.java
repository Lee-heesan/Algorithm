import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer> [] list;
	static int [] count;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		count = new int [N+1];
		for(int i= 1; i<=N ; i++) {
			list[i]= new ArrayList<Integer>();
		}
		
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
		}
		
		
		for(int i=1; i<=N; i++) {
			visited= new boolean[N+1];
			
			visited[i] =true;
			count[i]++;
			queue.add(i);
			
			bfs();
		}
		
		int maxCount = 0;
		for (int i = 1; i <= N; i++) {
			maxCount = Math.max(maxCount, count[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (count[i] == maxCount) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
		
	}
	
	

	public static void bfs() {
		while (!queue.isEmpty()) {
			int currentIdx = queue.remove();

			for (int nextIdx : list[currentIdx]) {
				if (!visited[nextIdx]) {
					visited[nextIdx] = true;
					count[nextIdx]++;
					queue.add(nextIdx);
				}
			}
		}
	}
}
