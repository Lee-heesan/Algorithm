import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    static Point[] SW, EW;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        SW = new Point[3];
        EW = new Point[3];

        int sIdx = 0, eIdx = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'B') SW[sIdx++] = new Point(i, j);
                if (map[i][j] == 'E') EW[eIdx++] = new Point(i, j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Wood> que = new LinkedList<>();
        boolean[][][] isVisited = new boolean[2][N][N];

        int dir = (SW[0].y + 1 == SW[1].y) ? 0 : 1;

        que.add(new Wood(SW[1].x, SW[1].y, dir, 0));
        isVisited[dir][SW[1].x][SW[1].y] = true;

        while (!que.isEmpty()) {
            Wood w = que.poll();
            int curX = w.x, curY = w.y, curDir = w.dir, curDist = w.dist;

            if (curX == EW[1].x && curY == EW[1].y) {
                if ((curDir == 0 && map[curX][curY - 1] == 'E' && map[curX][curY + 1] == 'E') ||
                    (curDir == 1 && map[curX - 1][curY] == 'E' && map[curX + 1][curY] == 'E')) {
                    return curDist;
                }
            }

            for (int t = 0; t < 4; t++) {
                int nx = curX + dx[t], ny = curY + dy[t];
                if (!checkMove(curDir, nx, ny, t) || isVisited[curDir][nx][ny]) continue;

                isVisited[curDir][nx][ny] = true;
                que.add(new Wood(nx, ny, curDir, curDist + 1));
            }

            if (canRotate(curX, curY) && !isVisited[1 - curDir][curX][curY]) {
                isVisited[1 - curDir][curX][curY] = true;
                que.add(new Wood(curX, curY, 1 - curDir, curDist + 1));
            }
        }

        return 0;
    }

    static boolean checkMove(int dir, int x, int y, int t) {
        // 기본적인 범위 체크
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        
        if (dir == 0) { // 가로 방향
            if (t < 2) { // 상/하 이동
                if (x < 0 || x >= N) return false;
            } else { // 좌/우 이동
                if (y - 1 < 0 || y + 1 >= N) return false;
            }
            return (y - 1 >= 0 && y + 1 < N) &&
                   (map[x][y] != '1' && map[x][y - 1] != '1' && map[x][y + 1] != '1');
        } else { // 세로 방향
            if (t >= 2) { // 좌/우 이동
                if (y < 0 || y >= N) return false;
            } else { // 상/하 이동
                if (x - 1 < 0 || x + 1 >= N) return false;
            }
            return (x - 1 >= 0 && x + 1 < N) &&
                   (map[x][y] != '1' && map[x - 1][y] != '1' && map[x + 1][y] != '1');
        }
    }


    static boolean canRotate(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || i >= N || j < 0 || j >= N || map[i][j] == '1') return false;
            }
        }
        return true;
    }

    static class Wood {
        int x, y, dir, dist;
        Wood(int x, int y, int dir, int dist) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dist = dist;
        }
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
