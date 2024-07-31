import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    int sizeOfArea = bfs(picture, visited, i, j, m, n);
                    numberOfArea++;
                    if (sizeOfArea > maxSizeOfOneArea) {
                        maxSizeOfOneArea = sizeOfArea;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int bfs(int[][] picture, boolean[][] visited, int x, int y, int m, int n) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int color = picture[x][y];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int size = 0;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];
            size++;
            
            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && picture[newX][newY] == color) {
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        
        return size;
    }
}