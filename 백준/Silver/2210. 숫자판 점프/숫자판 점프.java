import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean [] visited = new boolean[1000000];
	static int count;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,-1,1};
	static int [][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[5][5];
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		for(int i = 0; i<5; i++) {
			for(int j =0; j<5; j++) {
				dfs(i,j,arr[i][j],1);
			}
		}
		
		System.out.println(count);
	}
	
	public static void dfs(int x, int y,int str, int cnt) {
		if(cnt==6) {
			if(!visited[str]) {
				visited[str]= true;
				count++;
			}
			return;
		}
		
		
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx<5 && ny<5) {
				int nxtNum = str * 10 + arr[nx][ny];
				dfs(nx,ny,nxtNum,cnt+1);
			}
		}
	}
}
