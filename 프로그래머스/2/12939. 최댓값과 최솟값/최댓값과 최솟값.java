import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String [] str = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String ss : str){
            int now = Integer.parseInt(ss);
            
            min = Math.min(now,min);
            max = Math.max(now,max);
        }
        
        answer = Integer.toString(min)+" "+Integer.toString(max);
        
        return answer;
    }
}