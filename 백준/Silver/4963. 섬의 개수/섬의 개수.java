import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w,h;
	static int [][] map;
	static boolean [][] visited;
	static int cnt = 0;
	static int [] dx = {-1,0,1,-1,1,-1,0,1};
	static int [] dy = {-1,-1,-1,0,0,1,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		while(w!=0 && h!=0) {
			
			map = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			
			for(int i = 0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<h; i++) {
				for(int j =0; j<w; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int x, int y) {
		Queue<pos> queue = new LinkedList<pos>();
		queue.add(new pos(x,y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			pos NowPos = queue.poll(); 
			int NowPosX = NowPos.x;
			int NowPosY = NowPos.y;
			
			for(int i = 0; i<8; i++) {
				int nx = NowPosX + dx[i];
                int ny = NowPosY + dy[i];
                
                if(nx<0 || ny<0 || nx>=h || ny>=w ) {
                	continue;
                }
                
                if(map[nx][ny]==1 && !visited[nx][ny]) {
                	queue.add(new pos(nx,ny));
                	visited[nx][ny]=true;
                }
			}
			
		}
	}
	
	static class pos{
		int x;
		int y;
		
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
