import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static pos start;
    static Queue<pos> water = new LinkedList<>();
    static Queue<pos> hog = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    start = new pos(j, i);
                } else if (map[i][j] == '*') {
                    water.offer(new pos(j, i));
                }
            }
        }

        int result = bfs();
        System.out.print(result == -1 ? "KAKTUS" : result);
    }

    static int bfs() {
        hog.offer(start);
        visited[start.y][start.x] = true;
        map[start.y][start.x] = '.';

        int cnt = 0;

        while (!hog.isEmpty()) {
            // 1) 이번 분에 물 확장
            int waterSize = water.size();
            for (int w = 0; w < waterSize; w++) {
                pos now = water.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;

                    // 물은 빈칸(.)만 퍼짐, D는 못 들어감
                    if (map[ny][nx] == '.') {
                        map[ny][nx] = '*';
                        water.offer(new pos(nx, ny));
                    }
                }
            }

            // 2) 이번 분에 고슴도치 이동 (현재 hog 큐 크기만큼만!)
            int hogSize = hog.size();
            for (int h = 0; h < hogSize; h++) {
                pos now = hog.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
                    if (visited[ny][nx]) continue;
                    if (map[ny][nx] == 'X' || map[ny][nx] == '*') continue;

                    // 굴 도착!
                    if (map[ny][nx] == 'D') {
                        return cnt + 1;
                    }

                    visited[ny][nx] = true;
                    hog.offer(new pos(nx, ny));
                }
            }

            cnt++;
        }

        return -1;
    }

    static class pos {
        int x;
        int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
