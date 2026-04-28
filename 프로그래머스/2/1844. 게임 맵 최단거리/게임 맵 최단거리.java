import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,-1,1};
    static boolean [][] visited;
    static int n,m;
    static class Node{
        int Nx;
        int Ny;
        int cnt;
        
        public Node(int Nx,int Ny, int cnt){
            this.Nx = Nx;
            this.Ny = Ny;
            this.cnt = cnt;
        }
        
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        BFS(0,0,maps,1);
        // DFS(0,0,maps,1);
        
        if(answer==Integer.MAX_VALUE){
            answer = -1;
        }
        
        return answer;
    }
    
    public static void DFS(int x, int y,int[][] maps, int count){
        if(x==m-1&& y==n-1){
            answer = Math.min(answer,count);
            return;
        }
        

       if(count+1 > answer){
          return;
       }
        
        for(int i = 0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if(nx>m-1 || ny>n-1 || nx<0 || ny<0 ) continue;
            if(visited[ny][nx]) continue;
            if(maps[ny][nx]==0) {
                visited[ny][nx] = true;
                continue;
            }
            visited[ny][nx] = true;
            DFS(nx, ny, maps, count+1);
            visited[ny][nx] = false;
        }
    }
    
    
    public static void BFS(int x, int y,int[][] maps, int count){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,1));
        boolean [][] visited = new boolean [n][m];
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            for(int i = 0 ; i<4 ; i++){
                int nx = now.Nx + dx[i];
                int ny = now.Ny + dy[i];
                
                if(nx>m-1 || ny>n-1 || nx<0 || ny<0 ) continue;
                if(visited[ny][nx]) continue;
                if(maps[ny][nx]==0) {
                     visited[ny][nx] = true;
                     continue;
                }
                visited[ny][nx] = true;
                if(ny==n-1 && nx==m-1){
                    answer = now.cnt+1;
                    return;
                }
                queue.add(new Node(nx, ny, now.cnt+1));
            }
        }
    
    }
}