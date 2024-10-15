
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer>[] arr;
	static boolean visited[];
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		arr = new Stack[N+1];
		
		for(int i=1 ; i<=N; i++) {
			arr[i] = new Stack<Integer>();
		}
		
		for(int i =0 ; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());			
			int end = Integer.parseInt(st.nextToken());
			arr[start].add(end);
			arr[end].add(start);
		}
		
		count = 0;
		for(int i=1; i<=N; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i]=true;
			DFS(i);
			count++;
		}
		
		System.out.println(count);
		
	}
	
	public static void DFS(int i) {		
		while(!arr[i].isEmpty()) {
			visited[arr[i].peek()]=true;
			DFS(arr[i].pop());
		}
		
		if(arr[i].isEmpty()) {
			return;
		}
		
	}

}
