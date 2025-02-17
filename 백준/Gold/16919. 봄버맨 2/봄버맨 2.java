import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        List<int[]> bombList = new ArrayList<>();

        // 초기 상태 입력
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'O') {
                    bombList.add(new int[]{i, j});
                }
            }
        }

        // N이 1이면 초기 상태 출력
        if (N == 1) {
            printMap(map, sb);
        }
        // N이 짝수면 모든 칸을 'O'로 채움
        else if (N % 2 == 0) {
            fillWithBombs(sb);
        }
        // N이 3 이상 홀수일 때
        else {
            char[][] firstExplosion = simulateExplosion(bombList);
            char[][] secondExplosion = simulateExplosion(getBombPositions(firstExplosion));

            // N이 3 또는 7, 11...이면 첫 번째 폭발 후 상태
            if (N % 4 == 3) {
                printMap(firstExplosion, sb);
            }
            // N이 5 또는 9, 13...이면 두 번째 폭발 후 상태
            else {
                printMap(secondExplosion, sb);
            }
        }

        System.out.print(sb.toString());
    }

    // 맵을 출력하는 함수
    private static void printMap(char[][] map, StringBuilder sb) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }

    // 모든 칸을 폭탄('O')으로 채우는 함수
    private static void fillWithBombs(StringBuilder sb) {
        for (int i = 0; i < R; i++) {
            sb.append("O".repeat(C)).append("\n");
        }
    }

    // 폭발을 시뮬레이션하는 함수
    private static char[][] simulateExplosion(List<int[]> bombList) {
        char[][] newMap = new char[R][C];

        // 우선 모든 칸을 폭탄으로 채움
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newMap[i][j] = 'O';
            }
        }

        // 폭탄이 있던 위치와 주변 4방향을 폭파('.'으로 변경)
        for (int[] bomb : bombList) {
            int y = bomb[0], x = bomb[1];
            newMap[y][x] = '.';
            for (int d = 0; d < 4; d++) {
                int newY = y + dy[d];
                int newX = x + dx[d];

                if (newY >= 0 && newY < R && newX >= 0 && newX < C) {
                    newMap[newY][newX] = '.';
                }
            }
        }

        return newMap;
    }

    // 폭발 후 새로운 폭탄들의 위치를 찾는 함수
    private static List<int[]> getBombPositions(char[][] map) {
        List<int[]> bombList = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    bombList.add(new int[]{i, j});
                }
            }
        }
        return bombList;
    }
}
