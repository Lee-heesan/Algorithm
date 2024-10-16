
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static Stack<Integer> [] list;
	static boolean [] visited;
	static boolean result;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new Stack[N];
		visited = new boolean[N];
		for(int i =0; i<N; i++) {
			list[i]= new Stack<Integer>();
		}
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		for (int i = 0; i < N; i++) {
            if (!result) {
            	dfs(i, 1);
            }
        }

	    System.out.println(result?1:0);
    }

    public static void dfs(int start, int depth) {
        // 문제의 조건에 맞는 A, B, C, D, E가 존재
        if (depth == 5) {
            result = true;
            return;
        }
        visited[start] = true;
        for (int to : list[start]) {
            if (!visited[to]) {
                dfs(to, depth + 1);
            }
        }
        visited[start] = false;
    }
}