import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static List<String> words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] puzzle = new char[R][C];  // 퍼즐 저장 배열
        words = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                puzzle[i][j] = str.charAt(j);
            }
        }

        // 가로 단어 저장
        for (int i = 0; i < R; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < C; j++) {
                if (puzzle[i][j] != '#') {
                    word.append(puzzle[i][j]);
                } else {
                    if (word.length() >= 2) words.add(word.toString());
                    word.setLength(0); // 초기화
                }
            }
            if (word.length() >= 2) words.add(word.toString());
        }

        // 세로 단어 저장
        for (int i = 0; i < C; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < R; j++) {
                if (puzzle[j][i] != '#') {
                    word.append(puzzle[j][i]);
                } else {
                    if (word.length() >= 2) words.add(word.toString());
                    word.setLength(0);
                }
            }
            if (word.length() >= 2) words.add(word.toString());
        }

        // 정렬 후 사전순 가장 앞에 있는 단어 출력
        Collections.sort(words);
        System.out.println(words.get(0));
    }
}
