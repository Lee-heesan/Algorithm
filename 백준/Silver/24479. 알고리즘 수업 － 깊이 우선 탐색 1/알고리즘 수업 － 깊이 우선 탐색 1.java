
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> [] stack ;
	static int [] seq;
	static boolean [] visited;
	static int count;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		stack = new Stack[N+1];
		seq = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i =1 ; i<=N; i++) {
			stack[i] = new Stack<Integer>();
			seq[i]=0;
		}
		
		
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			
			int s  = Integer.parseInt(st.nextToken());
			int e  = Integer.parseInt(st.nextToken());
			
			stack[s].add(e);
			stack[e].add(s);
		}
		count=1;
		seq[R] = count++;
		for(int i=1; i<=N; i++) {
			stack[i].sort(Collections.reverseOrder());
		}
		DFS(R,0,R);
		
		
		for(int i =1; i<=N; i++) {
			sb.append(seq[i]+"\n");
		}
		System.out.println(sb.toString());
	}
	
	
	public static void DFS(int num , int depth, int start) {
		if(stack[num].isEmpty()) {
			return;
		}
		
		visited[num]=true;
		while(!stack[num].isEmpty()) {
			int to = stack[num].pop();
			if(!visited[to]) {
				if(seq[to]==0) {
					seq[to]=count++;
				}
				DFS(to, depth+1, start);	
			}
		}
	}

}
