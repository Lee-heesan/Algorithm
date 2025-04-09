import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R,C,T;
	static int [][] map;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	static pos [] air = new pos[2];
	static List<pos> list = new ArrayList<pos>();
	static class pos{
		int x;
		int y;
		int val;
		
		public pos() {
			
		}
		
		public pos(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int [R][C];
		air[0] = new pos(-1,-1,-1);
		air[1] = new pos(-1,-1,-1);
		for(int i =0; i<R; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(air[0].x==-1) {
						air[0].x = j;
						air[0].y = i;
					}else {
						air[1].x = j;
						air[1].y = i;
					}
				}else if (map[i][j] != -1 && map[i][j] != 0) {
					list.add(new pos(j,i,map[i][j]));
				}
			}
		}
		
		
		 for (int i = 0; i < T; i++) {
	         solve();
	     }
		 
	     int result = count();  
	 
	     System.out.println(result);
	}
	
	private static void solve() {
		list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1 && map[i][j] != 0) {
					list.add(new pos(j,i,map[i][j]));
				}
			}
		}
		fineDust();
		upAirPurifier();
		downAirPurifier();
	}
	
	private static void fineDust() {
	    for (pos cur : list) {
	        int div = cur.val / 5;
	        for (int j = 0; j < 4; j++) {
	            int nxtX = cur.x + dx[j];
	            int nxtY = cur.y + dy[j];
	            if (nxtX >= 0 && nxtX < C && nxtY >= 0 && nxtY < R && map[nxtY][nxtX] != -1) {
	            	map[nxtY][nxtX] += div; 
	            	map[cur.y][cur.x] -= div;  
	            }
	        }
	    }
	}


	private static void upAirPurifier() {
		// 청정기의 위쪽 좌표
		pos up = air[0];
		// 2행의 맨 끝자락을 기록해두고
		int temp_1 = map[up.y][C - 1];
		
		
		// 2행을 먼저 돌려주고
		for (int i = C - 1; i >= 2; i--) {
			map[up.y][i] = map[up.y][i - 1];
		}
			map[up.y][1] = 0;
		int temp_2 = map[0][C - 1];
		
		
		// 행 값 바꿔주기
		for (int i = 0; i < up.y - 1; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		map[up.y - 1][C - 1] = temp_1;
		// 맨 첫번째 행 돌려주고
		int temp_3 = map[0][0];
		
		
		
		for (int i = 0; i < C - 2; i++) {
			map[0][i] = map[0][i + 1];
		}
		map[0][C - 2] = temp_2;
		// 첫 번째 열을 돌려주기
		for (int i = up.y - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		map[1][0] = temp_3;
	}
	
	private static void downAirPurifier() {
		// 청정기의 아래쪽 좌표
		pos down = air[1];
		// 2행의 맨ㅌ 끝자락을 기록해두고
		int down_1 = map[down.y][C - 1];
			// -> 방향으로 돌려주고
		for (int i = C - 1; i >= 2; i--) {
			map[down.y][i] = map[down.y][i - 1];
		}
		map[down.y][1] = 0;
		int down_2 = map[R - 1][C - 1];
			// 아래방향으로 돌리고
		for (int i = R - 1; i > down.y + 1; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		map[down.y + 1][C - 1] = down_1;
			// <- 방향으로 돌리고
		int down_3 = map[R - 1][0];
		for (int i = 0; i < C - 2; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		map[R - 1][C - 2] = down_2;

		// 위에 방향으로 돌리기
		for (int i = down.y + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		map[R - 2][0] = down_3;
	}
	
	
	private static int count() {
		int cnt = 0;
		for(int i =0; i<R; i++) {
			for(int j =0; j<C; j++) {
				if(map[i][j] == -1) {
					continue;
				}
				cnt += map[i][j];
			}
		}
		return cnt;
	}
	
	
	private static void printMap() {
		for(int i =0; i<R; i++) {
			for(int j =0; j<C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
