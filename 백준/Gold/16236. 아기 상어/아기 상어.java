import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	 	static int[] dy = {-1, 0, 0, 1};
	    static int[] dx = {0, -1, 1, 0};
	    static int[][] map;
	    static  int[] baby;
	    static int size = 2;
	    public static void main(String[] args)throws IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());

	        map = new int[N][N];

	        for (int k = 0; k < N; k++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	        	for (int j = 0; j < N; j++) {
	                map[k][j] = Integer.parseInt(st.nextToken());
	                if (map[k][j] == 9) {
	                	baby = new int[]{k, j};
	                	map[k][j] = 0;
	                }
	        	}
	        }
	        	

	        int size = 2;
	        int eat = 0; // 먹은 물고기 수
	        int move = 0; // 움직인 총 거리

	        while (true) {
	        	PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
	        	    int cmp = Integer.compare(o1[2], o2[2]);
	        	    if (cmp != 0) return cmp;

	        	    
	        	    cmp = Integer.compare(o1[0], o2[0]);
	        	    if (cmp != 0) return cmp;

	        	    return Integer.compare(o1[1], o2[1]);
	        	});

	            boolean[][] visited = new boolean[N][N];

	            queue.add(new int[]{baby[0], baby[1], 0}); // y좌표, x좌표, 이동한 거리
	            visited[baby[0]][baby[1]] = true;

	            boolean isEat = false;

	            while (!queue.isEmpty()) {
	            	baby = queue.poll();

	                if (map[baby[0]][baby[1]] != 0 && map[baby[0]][baby[1]] < size) { 
	                    map[baby[0]][baby[1]] = 0; 
	                    eat++; 
	                    move += baby[2]; 
	                    isEat = true; 
	                    break;
	                }

	                for (int k = 0; k < 4; k++) {
	                    int ny = baby[0] + dy[k];
	                    int nx = baby[1] + dx[k];

	                    if (ny < 0 || nx < 0 || nx >= N || ny >= N || visited[ny][nx] || map[ny][nx] > size) {
	                        continue;
	                    }

	                    queue.add(new int[]{ny, nx, baby[2] + 1});
	                    visited[ny][nx] = true;
	                }
	            }

	            if (!isEat) 
	                break;

	            if (size == eat) { 
	                size++;
	                eat = 0;
	            }
	        }


	        System.out.println(move);

	    }


	}