import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Character, Integer> check = new HashMap<Character, Integer>(); // 각 문자의 최소 등장 횟수
    static char[] Arr; // 입력된 DNA 문자열 배열
    static Map<Character, Integer> map = new HashMap<Character, Integer>(); // 현재 슬라이딩 윈도우 내 문자 등장 횟수
    static char[] C = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이
        int result = 0; // 결과값 (만족하는 비밀번호의 개수)
        int checkSecret = 0; // 4개의 문자 조건을 만족하는 개수

        Arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            check.put(C[i], num); // 최소 등장 횟수 조건 저장
            if (num == 0) {
                checkSecret++; // 해당 문자가 0개 이상이면 이미 만족하는 조건
            }
        }

        // 초기 슬라이딩 윈도우 설정 (0부터 P-1까지)
        for (int i = 0; i < P; i++) {
            map.put(Arr[i], map.getOrDefault(Arr[i], 0) + 1);
            if (map.get(Arr[i]).equals(check.get(Arr[i]))) {
                checkSecret++; // 해당 문자가 최소 요구량을 만족할 때만 증가
            }
        }

        if (checkSecret == 4) {
            result++;
        }

        // 슬라이딩 윈도우 진행 (P부터 S-1까지)
        for (int i = P; i < S; i++) {
            // 1. 새로 추가되는 문자 처리
            map.put(Arr[i], map.getOrDefault(Arr[i], 0) + 1);
            if (map.get(Arr[i]).equals(check.get(Arr[i]))) {
                checkSecret++; // 추가된 문자가 조건을 만족하면 checkSecret 증가
            }

            // 2. 슬라이딩 윈도우에서 제거되는 문자 처리
            int rm = i - P;
            if (map.get(Arr[rm]).equals(check.get(Arr[rm]))) {
                checkSecret--; // 제거될 문자가 조건을 만족하고 있었다면 checkSecret 감소
            }
            map.put(Arr[rm], map.get(Arr[rm]) - 1); // 문자 개수 감소

            // 3. 조건 만족 여부 확인
            if (checkSecret == 4) {
                result++;
            }
        }

        System.out.println(result);
    }
}
