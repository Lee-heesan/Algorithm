import java.util.*;
import java.io.*;

public class Main{
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int N,M;
    static int [][] arr;
    static boolean [][] visited;
    static int count = 0;
    static int max = 0;
    static int brokeMax = 0;

    // 서 북 동 남
    static int [] dx = {0,-1,0,1};
    static int [] dy = {-1,0,1,0};

    static int [][] idxArr;
    static int [] room;

    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        idxArr = new int[N][M];
        room = new int[N*M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j]) continue;

                int size = BFS(i,j,count);
                room[count] = size;
                max = Math.max(max,size);
                count++;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int k=0;k<4;k++){

                    if((arr[i][j] & (1<<k)) == 0) continue;

                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                    int r1 = idxArr[i][j];
                    int r2 = idxArr[nx][ny];

                    if(r1 != r2){
                        brokeMax = Math.max(brokeMax, room[r1] + room[r2]);
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
        System.out.println(brokeMax);
    }

    public static int BFS(int x,int y,int roomNum){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        idxArr[x][y] = roomNum;

        int size = 1;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i=0;i<4;i++){

                if((arr[now.x][now.y] & (1<<i)) != 0) continue;

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                idxArr[nx][ny] = roomNum;
                q.add(new Node(nx,ny));
                size++;
            }
        }

        return size;
    }
}