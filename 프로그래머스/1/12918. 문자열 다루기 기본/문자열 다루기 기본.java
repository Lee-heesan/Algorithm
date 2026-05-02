import java.util.*;

class Solution {
    public boolean solution(String s) {
        
        if(s.length()!=4 && s.length()!=6){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if (!Character.isDigit(now)) {
                return false;
            }
        }

        return true;
    }
}