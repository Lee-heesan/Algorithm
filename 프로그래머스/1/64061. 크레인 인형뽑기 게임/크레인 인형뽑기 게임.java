import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
		Stack<Integer> basket  = new Stack<Integer>();
		
		for (int move : moves) {
	            int column = move - 1;  
	            for (int row = 0; row < board.length; row++) {
	                if (board[row][column] != 0) {  
	                    int picked = board[row][column];
	                    board[row][column] = 0; 
	                    
	                    if (!basket.isEmpty() && basket.peek() == picked) {
	                        basket.pop();  
	                        answer += 2;  
	                    } else {
	                        basket.push(picked);  
	                    }
	                    break;  
	                }
	            }
	     }
        return answer;
    }
}