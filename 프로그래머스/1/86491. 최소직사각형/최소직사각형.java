import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        Integer [] width = new Integer[sizes.length];
        Integer [] height = new Integer[sizes.length];
        
        for(int i = 0; i<sizes.length; i++){
            int first = sizes[i][0];
            int second = sizes[i][1];
            if(first>=second){
                width[i] = sizes[i][0];
                height[i] = sizes[i][1];
            }else{
                 width[i] = sizes[i][1];
                 height[i] = sizes[i][0];
            }
        }
        
        Arrays.sort(width,Collections.reverseOrder());
        Arrays.sort(height,Collections.reverseOrder());
        
        answer = width[0] * height[0];
        
        return answer;
    }
}