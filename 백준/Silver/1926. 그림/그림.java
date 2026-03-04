import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr;
	static boolean [][] visited;
	static int max = 0;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;

		for(int i=0;i<n;i++){
		    for(int j=0;j<m;j++){
		        if(arr[i][j]==1 && !visited[i][j]){
		            int area = bfs(i,j);
		            count++;
		            max = Math.max(max, area);
		        }
		    }
		}
		
		System.out.println(count);
		System.out.println(max);
	}
	
	static int bfs(int y, int x){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[]{y,x});
	    visited[y][x] = true;

	    int area = 1;

	    while(!q.isEmpty()){
	        int[] cur = q.poll();
	        int cy = cur[0];
	        int cx = cur[1];

	        for(int i=0;i<4;i++){
	            int ny = cy + dy[i];
	            int nx = cx + dx[i];

	            if(ny>=0 && ny<n && nx>=0 && nx<m){
	                if(arr[ny][nx]==1 && !visited[ny][nx]){
	                    visited[ny][nx] = true;
	                    q.add(new int[]{ny,nx});
	                    area++;
	                }
	            }
	        }
	    }
	    return area;
	}}
