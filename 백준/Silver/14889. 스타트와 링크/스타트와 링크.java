import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [][] map;
	static boolean [] visited;
	static int result;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		cal(0,0);
			
		System.out.println(result);
	}
	
	private static void cal(int idx, int count) {
		if(count==N/2) {
			result = Math.min(diff(), result);
			return;
		}
		
		for(int i = idx; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				cal(i+1,count+1);
				visited[i]=false;
			}
		}
	}
	
	private static int diff() {
		int teamS = 0;
		int teamL = 0;
		
		for(int i = 0; i<N-1; i++) {
			for(int j = i+1; j<N; j++) {
				if(visited[i] && visited[j]) {
					teamS += (map[i][j]+map[j][i]);
				}else if(!visited[i] && !visited[j]) {
					teamL += (map[i][j]+map[j][i]);
				}
			}
		}
		
		return Math.abs(teamS - teamL);
	}
}
