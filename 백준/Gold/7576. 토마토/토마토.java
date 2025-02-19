import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,N;
	static int [][] map;
	static int startX,startY;
	static boolean [][]visited;
	static Queue<int []> queue;
	static int [] dx = {0,1,0,-1}; //위 , 오른쪽, 밑, 아래
	static int [] dy = {1,0,-1,0};
	static int result = 0;
	static int count  = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];

		queue = new LinkedList<>();	
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					queue.add(new int[] {j,i,0});
					visited[i][j] = true;
					count++;
				}else if(map[i][j]==-1) {
					visited[i][j]= true;
					count++;
				}
			}
		}

		BFS();
			
		if(count== N*M) {
			System.out.println(result);	
		}else {
			System.out.println(-1);
		}
	}
	
	private static void BFS() {
		while(!queue.isEmpty()) {
			int [] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			int nowDay = now[2];
			
			for(int i =0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && !visited[nextY][nextX] && map[nextY][nextX]==0) {
					map[nextY][nextX] = 1;
					visited[nextY][nextX] = true;
					queue.add(new int[] {nextX, nextY, nowDay+1});
					result = Math.max(nowDay+1, result);
					count++;
				}
			}
		}
	}

}
