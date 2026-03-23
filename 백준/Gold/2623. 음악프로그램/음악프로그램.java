import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int [] indegree;
	static List<Integer> [] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N+1];
		list = new LinkedList[N+1];
		for(int i = 1; i<=N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int PDCnt = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			
			for(int j =1; j<PDCnt; j++) {
				int now = Integer.parseInt(st.nextToken());
				
				indegree[now]++;
				list[prev].add(now);
				prev = now;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i<=N; i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			sb.append(now).append("\n");
			count++;
			
			for(int nxt : list[now]) {
				indegree[nxt]--;
				
				if(indegree[nxt]==0) {
					queue.add(nxt);
				}
			}
		}
		
		if(count != N) {
		    System.out.println(0);
		} else {
		    System.out.println(sb.toString());
		}
	
	}
}
