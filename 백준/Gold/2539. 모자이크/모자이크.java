import java.io.*;
import java.util.*;

public class Main {
    static int X, Y;
    static int confetti;
    static int wrongCnt;
    static int result;
    static List<Pos> wrongList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken()); 
        X = Integer.parseInt(st.nextToken()); 
        int maxSize = Math.min(X, Y);

        confetti = Integer.parseInt(br.readLine());
        wrongCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < wrongCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            wrongList.add(new Pos(col, row)); 
        }

        wrongList.sort(Comparator.comparingInt(o -> o.x));

        result = maxSize;
        binarySearch(1, maxSize);
        System.out.print(result);
    }

    static int binarySearch(int start, int end) {
        if (start > end) {
        	return result;
        }

        int mid = (start + end) / 2;
        int need = cal(mid);

        if (need <= confetti) {
            result = Math.min(result, mid);
            return binarySearch(start, mid - 1);
        } else {
            return binarySearch(mid + 1, end);
        }
    }

    static int cal(int s) {
        int used = 0;
        int coverEndX = Integer.MIN_VALUE;

        for (Pos p : wrongList) {
        	if (p.y > s) {
            	return confetti + 1;
            }
        	
            if (p.x > coverEndX) { 
                used++;
                if (used > confetti) {
                	return used;
                }
                coverEndX = p.x + s - 1; 
            }
        }
        return used;
    }

    static class Pos {
        int x; 
        int y; 
        Pos(int x, int y) { this.x = x; this.y = y; }
    }
}
