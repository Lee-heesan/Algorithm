import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while(!isTrue()) { 
			visited = new boolean[N][M];
			visited[0][0] = true;
			DFS(0,0); //외부 공기 찾기
			cheese();
			change();
			ans++;
		}
		
		System.out.println(ans);
	}
	
	private static boolean isTrue() {
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (map[i][j] == 1) {  // 치즈가 남아 있으면
	                return false;
	            }
	        }
	    }
	    return true;  // 치즈가 모두 녹았을 경우
	}


	
	// 외부에 공기 표시
	private static void DFS(int Y, int X) {
		for(int i =0; i<4;i++) {
			int newY = Y+dy[i];
			int newX = X+dx[i];
			
			if(newY>=0 && newY<N && newX>=0 && newX<M && map[newY][newX]==0 && !visited[newY][newX]) {
				visited[newY][newX] = true;
				DFS(newY,newX);
			}
		}
	}
	
	
	
	// 외부 공기랑 닿이면서 1인 치즈 찾기
	private static void cheese() {			
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					int cnt =0;
					for(int k =0; k<4;k++) {
						int newY = i+dy[k];
						int newX = j+dx[k];
						
						if(visited[newY][newX]) {
							cnt++;
						}
					}
					
					if(cnt>=2) {
						map[i][j] =2;
					}
				}
			}
		}
	}
	
	//2로 바꿔준 치즈 변경
	private static void change() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					map[i][j]=0;
				}
			}
		}
	}
}
