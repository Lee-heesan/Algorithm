import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
                "0110111", "0001011" };
        String part = "";
        int[] answer = new int[8];
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int length = Integer.parseInt(input[0]);
            int width = Integer.parseInt(input[1]);
            boolean isFind = false;

            // 입력을 받고 1이 마지막으로 나오는 위치 찾기
            for (int j = 0; j < length; j++) {
                String str = br.readLine();
                if (!isFind) {
                    for (int k = str.length() - 1; k >= 55; k--) {
                        if (str.charAt(k) == '1') {
                            part = str.substring(k - 55, k + 1);
                            isFind = true;
                            break;
                        }
                    }
                }
            }

            int position = 0;

            // 일치하는 코드 찾기
            for (int j = 0; j < part.length(); j += 7) {
                String tmp = part.substring(j, j + 7);
                for (int k = 0; k < code.length; k++) {
                    if (tmp.equals(code[k])) {
                        answer[position++] = k;
                        break;
                    }
                }
            }

            sum1 = answer[0] + answer[2] + answer[4] + answer[6];
            sum2 = answer[1] + answer[3] + answer[5] + answer[7];

            if ((sum1 * 3 + sum2) % 10 == 0) {
                sb.append("#" + (i + 1) + " " + (sum1 + sum2) + "\n");
            } else {
                sb.append("#" + (i + 1) + " " + 0 + "\n");
            }
        }

        System.out.print(sb.toString());
    }
}
