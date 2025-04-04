import java.util.*;
import java.io.*;
public class Solution{
    static int N;
    static int M;
    static int[][] map;
    static int answer=Integer.MIN_VALUE;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tr=1; tr<=T; tr++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
 
            answer=0;
 
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            secure();
 
            bw.write("#"+tr+" "+String.valueOf(answer));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
 
    }
 
    public static void secure(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Queue<Point> queue = new LinkedList<>();
                boolean[][] visited = new boolean[N][N];
                int cnt = 0;
                int K = 1;
                queue.offer(new Point(i,j,1));
                visited[i][j] = true;
                while (!queue.isEmpty()){
                    int level = queue.size();
                    for(int t=0; t<level; t++){
                        Point cur = queue.poll();
                        if(map[cur.x][cur.y] == 1){
                            cnt++;
                        }
                        for(int l=0; l<4; l++){
                            int nextX = cur.x + dx[l];
                            int nextY = cur.y + dy[l];
                            if(nextX<0||nextY<0||nextX>=N||nextY>=N) continue;
                            if(visited[nextX][nextY]) continue;
                            queue.offer(new Point(nextX,nextY, cur.k +1));
                            visited[nextX][nextY] = true;
                        }
                    }
                    int cost = K*K+(K - 1)*(K - 1);
                    if(cnt*M >= cost){
                        answer = Math.max(cnt,answer);
                    }
                    K++;
                }
 
            }
        }
    }
 
 
 
 
 
    public static class Point{
        int x;
        int y;
        int k;
 
        public Point(int x,int y,int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
 
 
 
 
 
 
}