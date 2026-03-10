import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dist = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int island = 2;

        // 1️⃣ 섬 번호 붙이기
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    labelIsland(i,j,island++);
                }
            }
        }

        // 2️⃣ 모든 섬을 큐에 넣기
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] > 0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        // 3️⃣ 멀티 BFS
        int answer = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int y = cur[0];
            int x = cur[1];

            for(int i=0;i<4;i++){

                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny<0||nx<0||ny>=N||nx>=N) continue;

                // 바다 확장
                if(map[ny][nx]==0){
                    map[ny][nx] = map[y][x];
                    dist[ny][nx] = dist[y][x] + 1;
                    queue.add(new int[]{ny,nx});
                }

                // 다른 섬 만나면
                else if(map[ny][nx] != map[y][x]){
                    answer = Math.min(answer, dist[ny][nx] + dist[y][x]);
                }
            }
        }

        System.out.println(answer);
    }

    static void labelIsland(int y,int x,int num){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});

        visited[y][x] = true;
        map[y][x] = num;

        while(!q.isEmpty()){

            int[] cur = q.poll();

            for(int i=0;i<4;i++){

                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny<0||nx<0||ny>=N||nx>=N) continue;

                if(map[ny][nx]==1 && !visited[ny][nx]){

                    visited[ny][nx] = true;
                    map[ny][nx] = num;
                    q.add(new int[]{ny,nx});
                }
            }
        }
    }
}