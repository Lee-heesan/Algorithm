import java.util.*;

class Solution {
    static int left = 10;  
    static int right = 12; 

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            }
            else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            }
            else {
                int leftDist = cal(left, num);
                int rightDist = cal(right, num);

                if (leftDist < rightDist) {
                    sb.append("L");
                    left = num;
                } else if (rightDist < leftDist) {
                    sb.append("R");
                    right = num;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right = num;
                    } else {
                        sb.append("L");
                        left = num;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static int cal(int now, int target) {
        if (now == 0){
            now = 11;
        }
        if (target == 0){
           target = 11;
        }

        int x1 = (now - 1) / 3;
        int y1 = (now - 1) % 3;

        int x2 = (target - 1) / 3;
        int y2 = (target - 1) % 3;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}