import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (cal(diffs, times, limit, mid) <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public static long cal(int[] diffs, int[] times, long limit, int num) {
        long total = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (num >= diffs[i]) {
                total += times[i];
            } else {
                int fail = diffs[i] - num;

                long prevTime = (i == 0) ? 0 : times[i - 1];

                long c = (times[i] + prevTime) * fail + times[i];
                total += c;
            }

            if (total > limit) {
                return total;
            }
        }

        return total;
    }
}