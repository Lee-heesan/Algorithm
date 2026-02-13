import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int algorithm = Integer.parseInt(st.nextToken());

            if (algorithm == 1) {
                arr = one();
            } else if (algorithm == 2) {
                arr = two();
            } else if (algorithm == 3) {
                arr = three();
            } else if (algorithm == 4) {
                arr = four();
            } else if (algorithm == 5) {
                arr = five();
            } else if (algorithm == 6) {
                arr = six();
            }

            N = arr.length;
            M = arr[0].length;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 1) 상하 반전
    public static int[][] one() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[n - 1 - i][j];
            }
        }
        return tmp;
    }

    // 2) 좌우 반전
    public static int[][] two() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[i][m - 1 - j];
            }
        }
        return tmp;
    }

    // 3) 오른쪽 90도 회전 (N x M -> M x N)
    public static int[][] three() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[j][n - 1 - i] = arr[i][j];
            }
        }
        return tmp;
    }

    // 4) 왼쪽 90도 회전 (N x M -> M x N)
    public static int[][] four() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[m - 1 - j][i] = arr[i][j];
            }
        }
        return tmp;
    }

    // 5) 사분면 시계방향 이동
    // 1->2, 2->3, 3->4, 4->1
    public static int[][] five() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[n][m];
        int n2 = n / 2;
        int m2 = m / 2;

        // 1 -> 2
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                tmp[i][j + m2] = arr[i][j];
            }
        }
        // 2 -> 3
        for (int i = 0; i < n2; i++) {
            for (int j = m2; j < m; j++) {
                tmp[i + n2][j] = arr[i][j];
            }
        }
        // 3 -> 4
        for (int i = n2; i < n; i++) {
            for (int j = m2; j < m; j++) {
                tmp[i][j - m2] = arr[i][j];
            }
        }
        // 4 -> 1
        for (int i = n2; i < n; i++) {
            for (int j = 0; j < m2; j++) {
                tmp[i - n2][j] = arr[i][j];
            }
        }
        return tmp;
    }

    // 6) 사분면 반시계방향 이동
    // 1->4, 4->3, 3->2, 2->1
    public static int[][] six() {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[n][m];
        int n2 = n / 2;
        int m2 = m / 2;

        // 1 -> 4
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                tmp[i + n2][j] = arr[i][j];
            }
        }
        // 4 -> 3
        for (int i = n2; i < n; i++) {
            for (int j = 0; j < m2; j++) {
                tmp[i][j + m2] = arr[i][j];
            }
        }
        // 3 -> 2
        for (int i = n2; i < n; i++) {
            for (int j = m2; j < m; j++) {
                tmp[i - n2][j] = arr[i][j];
            }
        }
        // 2 -> 1
        for (int i = 0; i < n2; i++) {
            for (int j = m2; j < m; j++) {
                tmp[i][j - m2] = arr[i][j];
            }
        }
        return tmp;
    }
}
