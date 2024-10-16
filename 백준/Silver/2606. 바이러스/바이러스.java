
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> [] list; 
	static int count; 
	static boolean [] visited;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		
		int N = Integer.parseInt(br.readLine());
		list = new Stack[N+1];
		visited = new boolean[N+1];
		
		for(int i =1; i<=N; i++ ) {
			list[i]= new Stack<Integer>();
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i =0; i<M; i++) {
			st =  new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		// 1번 컴퓨터 웜
		count = 0;
		DFS(1);
		
		System.out.println(count);

	}
	
	public static void DFS(int num) {
		if(list[num].isEmpty()) {
			return;
		}
		
		visited[num]= true;
		while(!list[num].isEmpty()) {
			int to = list[num].pop();
			if(!visited[to]) {
				count++;
				DFS(to);	
			}
		}
		
		
	}

}
