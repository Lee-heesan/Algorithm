import java.io.*;
import java.util.*;

public class Main {
	//1516 위상정렬
	static List<Integer> [] list ;
	static int D [];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		D = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		int [] time = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			
			int num = Integer.parseInt(st.nextToken());
			while(num!=-1) {
				list[num].add(i);
				D[i]++;
				num = Integer.parseInt(st.nextToken());
			}

		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i =1; i<=N; i++) {
			if(D[i]==0) {
				queue.offer(i);
			}
		}
		
		int []result = new int [N+1];
		 while (!queue.isEmpty()) {
	            int now = queue.poll();

	            for (int next : list[now]) {
	                D[next]--;
	                result[next] = Math.max(result[next], result[now] + time[now]);
	                if (D[next] == 0) {
	                    queue.offer(next);
	                }
	            }
	        }
		
		for(int i=1; i<=N; i++) {
			sb.append((result[i]+time[i])+"\n");
		}
		
		System.out.println(sb);
	}
}