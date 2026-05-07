import java.util.*;

class Solution {
    static int [] arr;
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        
        int ansIdx = 0;
        for(int i =0; i<commands.length; i++){
            int I = commands[i][0];
            int J = commands[i][1];
            int K = commands[i][2];
            
            
            arr = new int[J-I+1];
            
            int idx = 0;
            for(int j = I; j<=J; j++){
                arr[idx] = array[j-1];
                idx++;
            }
            
            Arrays.sort(arr);
                        
            answer[ansIdx] = arr[K-1];
            ansIdx++;
        }
        
        return answer;
    }
}