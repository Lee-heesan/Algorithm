
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int N, M;
    static int[] dirX = {1, 0, -1, 0};  // 오른쪽, 아래, 왼쪽, 위
    static int[] dirY = {0, 1, 0, -1};  // 오른쪽, 아래, 왼쪽, 위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';  // 문자 '1'을 정수 1로 변환
            }
        }

        System.out.println(BFS(0, 0));
    }

    public static int BFS(int startX, int startY) {
    	Queue<int []> q  = new LinkedList<int[]>();
    	q.add(new int[] {startX, startY,1});
    	visited[startX][startY] = true;
    	
    	
    	while(!q.isEmpty()) {
    		int [] now = q.poll();
    		int x = now[0];
    		int y = now[1];
    		int depth = now[2];
    		
    		
    		if(x==M-1&&y==N-1) {
    			return depth;
    		}
    		
    		for(int i =0; i<4; i++) {
    			int newX = x+dirX[i];
    			int newY = y+dirY[i];
    			
    			if(newX>=0 && newX<M && newY>=0 && newY<N && arr[newY][newX]==1 && !visited[newY][newX]) {
    				q.add(new int[] {newX, newY, depth+1});
    				visited[newY][newX]=true;
    			}
    		}
    	}
    	
    	
    	return -1;
    }
}
