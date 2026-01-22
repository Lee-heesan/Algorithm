import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [][] arr;
	static boolean [][] visited;
	static int cnt = 0;
	static int listCnt;
	static PriorityQueue<Integer> list = new PriorityQueue<Integer>();
	static int [] dx = {-1,0,0,1};
	static int [] dy = {0,-1,1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		visited = new boolean [N][N];
		for(int i = 0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<tmp.length; j++) {
				arr[i][j] = tmp[j] - '0';
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					listCnt = 1;
					cnt++;
					DFS(i,j);
					list.add(listCnt);
				}
			}
		}
		
		sb.append(cnt).append("\n");
		while(!list.isEmpty()) {
			sb.append(list.poll()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i<4; i++) {
			int newX = dx[i]+x;
			int newY = dy[i]+y;
			
			if(newX>=0 && newY>=0 && newX<N && newY<N && !visited[newX][newY] && arr[newX][newY]==1) {
				listCnt++;
				DFS(newX,newY);
			}
		}
	}
}
