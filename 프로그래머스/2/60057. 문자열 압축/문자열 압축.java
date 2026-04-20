import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length(); 
        
        for(int i = 1; i <= s.length() / 2; i++){
            StringBuilder sb = new StringBuilder();
            int start = 0;
            
            while(start < s.length()){
                
                int end = Math.min(start + i, s.length());
                String now = s.substring(start, end);
                
                int count = 1;
                
                while(start + i * count + i <= s.length() &&
                      s.substring(start + i * count, start + i * (count + 1)).equals(now)){
                    count++;
                }
                
                if(count > 1){
                    sb.append(count).append(now); 
                } else {
                    sb.append(now);
                }
                
                start += i * count;
            }
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}