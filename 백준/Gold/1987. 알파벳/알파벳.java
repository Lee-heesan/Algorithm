import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char [][] arr;
	static boolean [][] visited;
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char [R][C];
		visited = new boolean[R][C];
		
		for(int i =0; i<R; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		visited[0][0]=true;
		map.put(arr[0][0], 1);
		DFS(map,0,0,1);
		System.out.println(max);
	}
	
	public static void DFS(Map<Character, Integer> map, int x, int y, int cnt) {
		 max = Math.max(max, cnt);
		for(int i = 0; i<4; i++) {
			int nxtX = x+dx[i];
			int nxtY = y+dy[i];
			
			if(nxtX>=0 && nxtY>=0 && nxtX<C && nxtY<R && !visited[nxtY][nxtX]) {
				if(map.containsKey(arr[nxtY][nxtX])) {
					continue;
				}
				visited[nxtY][nxtX] = true;
				map.put(arr[nxtY][nxtX], 1);
				DFS(map,nxtX,nxtY,cnt+1);
				visited[nxtY][nxtX] = false;
				map.remove(arr[nxtY][nxtX]);
			}
		}
	}

}
