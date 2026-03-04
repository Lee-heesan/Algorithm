import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr;
	static boolean [][] visited;
	static int max = 0;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		for(int i =0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					int area = dfs(i, j);
		            count++;
		            max = Math.max(max, area);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}
	
	private static int dfs(int y, int x) {
	    visited[y][x] = true;
	    int area = 1;

	    for (int i = 0; i < 4; i++) {
	        int ny = y + dy[i];
	        int nx = x + dx[i];

	        if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && arr[ny][nx] == 1) {
	            area += dfs(ny, nx);
	        }
	    }
	    return area;
	}
}
