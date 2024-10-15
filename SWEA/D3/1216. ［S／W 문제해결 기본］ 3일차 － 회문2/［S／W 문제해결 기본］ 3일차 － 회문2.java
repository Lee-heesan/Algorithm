import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static char[][] board; // 문자판 배열
    static final int SIZE = 100; // 문자판 크기

    public static boolean hasPalindrome(int length) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col <= SIZE - length; col++) {
                if (isPalindromeInRow(row, col, length) || isPalindromeInCol(col, row, length)) {
                    return true; 
                }
            }
        }
        return false; 
    }

    // 가로 방향 회문 검사
    public static boolean isPalindromeInRow(int row, int startCol, int length) {
        for (int offset = 0; offset < length / 2; offset++) {
            if (board[row][startCol + offset] != board[row][startCol + length - 1 - offset]) {
                return false;
            }
        }
        return true; 
    }

    // 세로 방향 회문 검사
    public static boolean isPalindromeInCol(int startRow, int col, int length) {
        for (int offset = 0; offset < length / 2; offset++) {
            if (board[startRow + offset][col] != board[startRow + length - 1 - offset][col]) {
                return false;
            }
        }
        return true; 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 0; testCase < 10; testCase++) {
            int t = Integer.parseInt(br.readLine()); 
            board = new char[SIZE][SIZE]; 

            // 문자판 입력
            for (int row = 0; row < SIZE; row++) {
                String line = br.readLine();
                for (int col = 0; col < SIZE; col++) {
                    board[row][col] = line.charAt(col);
                }
            }

            // 가장 긴 회문 찾기
            for (int length = SIZE; length > 0; length--) {
                if (hasPalindrome(length)) {
                    System.out.println("#" + t + " " + length);
                    break; 
                }
            }
        }
        br.close();
    }
}
