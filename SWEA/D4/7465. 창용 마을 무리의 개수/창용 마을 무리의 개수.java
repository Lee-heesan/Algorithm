import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution
{
    static ArrayList<Integer> [] arr;
	static boolean [] visited;

	static void dfs(int cur) {
		visited[cur]= true;
		
		for(int i= 0 ; i < arr[cur].size(); i++) {
			if(visited[arr[cur].get(i)]) {
				continue;
			}
			dfs(arr[cur].get(i));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i =1; i<=T; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			arr = new ArrayList [N+1];
			visited = new boolean[N+1];
			for(int j=1; j<= N; j++) {
				arr[j] = new ArrayList<Integer>();
			}
			
			for(int j =0; j<M; j++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from].add(to);
				arr[to].add(from);
				
			}
			int count =0;
			for(int j = 1; j <= N; j++) {
				if(visited[j]) continue;
				dfs(j);
				count++;
			}
			
			sb.append("#").append(i).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}