import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }else{
                stack.add(count++);
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }

        return answer;
    }
}