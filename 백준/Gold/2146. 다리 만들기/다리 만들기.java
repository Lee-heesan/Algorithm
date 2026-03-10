import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [][] arr;
	static int [][] newMap; 
	static boolean [][] visited;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,-1,1};
	static int min;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		visited = new boolean [N][N];
		newMap = new int [N][N];
		StringTokenizer st;
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int island=1;
		for(int i =0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					bfs(i,j,island);
					island++;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i =0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(newMap[i][j]>0) {
					Searchbfs(i,j,newMap[i][j]);
				}
			}
		}
		
		System.out.println(min);
	}
	
	public static void bfs(int y, int x, int island) {
		Queue<int []> queue = new LinkedList<int []>();
		queue.add(new int[] {y,x});
		visited[y][x] = true;
		newMap[y][x] = island;
		
		while(!queue.isEmpty()) {
			int [] now = queue.poll();
			for(int i =0; i<4; i++) {
				int nx = now[1]+dx[i];
				int ny = now[0]+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && arr[ny][nx]==1 && !visited[ny][nx]) {
					queue.add(new int[] {ny,nx});
					newMap[ny][nx] = island;
					visited[ny][nx] = true;
				}
			}
		}		
	}
	
	public static void Searchbfs(int y, int x, int nowIsland) {
		Queue<int []> queue = new LinkedList<int []>();
		queue.add(new int[] {y,x,0});
		visited = new boolean[N][N];
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			int [] now = queue.poll();
			for(int i =0; i<4; i++) {
				int nx = now[1]+dx[i];
				int ny = now[0]+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[ny][nx]) {
					if(newMap[ny][nx]==0) {
						queue.add(new int[] {ny,nx,now[2]+1});
						visited[ny][nx] = true;
					}else if(nowIsland!=newMap[ny][nx]) {
						min = Math.min(min, now[2]);
					}
				}
			}
		}	
	}

}
