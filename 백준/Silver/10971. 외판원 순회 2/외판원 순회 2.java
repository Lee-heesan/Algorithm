import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }

        System.out.println(answer);
    }
    
    public static void dfs(int start, int now, int sum, int depth) {
    	if(depth == N-1) {
    		if (arr[now][start] != 0) {
        		int total  = sum+arr[now][start];
        		answer = Math.min(answer, total);	
    		}
    		return;
    	}
    	
    	for(int i =0; i<N; i++) {
    		if(arr[now][i] != 0 && !visited[i]) {
    			visited[i] = true;
    			dfs(start,i,sum+arr[now][i],depth+1);
    			visited[i] = false;
    		}
    	}
    }

}