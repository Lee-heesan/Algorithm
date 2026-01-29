import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int [] dx = {0,1,0,-1}; //북동남서 
	static int [] dy = {-1,0,1,0}; //북동남서
	static int [][] map;
	static boolean [][] visited;
	static int result=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		int startDir = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int nxtY = startY;
		int nxtX = startX;
		int dir = startDir;
		int result = 0;
		
		while (true) {
			//현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(map[nxtY][nxtX]==0) {
				map[nxtY][nxtX] = 2;
				result++;
			}
			
			//현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			boolean moved = false;
			for(int i = 0; i<4; i++) {
				dir = (dir+3)%4;
				int nr = nxtY + dy[dir];
				int nc = nxtX + dx[dir];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0) {
					nxtY = nr;
					nxtX = nc;
					moved = true;
					break;
				}
			}
			
			if(moved) {
				continue;
			}
			
			//현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			int backDir = (dir + 2) % 4;
	        int brR = nxtY + dy[backDir];
	        int brC = nxtX + dx[backDir];
	        
	        
	        if (brR < 0 || brR >= N || brC < 0 || brC >= M || map[brR][brC] == 1) {
                break; 
            } else {
                nxtY = brR;
                nxtX = brC;
            }
		}
        System.out.println(result);
	}
}
