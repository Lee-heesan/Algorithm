import java.util.*;

class Solution {
    static int answer = 0;
    static class Node{
        int pos;
        int total;
        
        public Node(int pos, int total){
            this.pos = pos;
            this.total = total;
        }
    }
    public int solution(int[] numbers, int target) {
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,numbers[0]));
        queue.add(new Node(0,-numbers[0]));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int nowPos = now.pos;
            int nowTotal = now.total;
            
            if(nowPos==numbers.length-1){
                if(nowTotal == target){
                    answer++;
                }
                continue;
            }
            
            for(int i = 0; i<2; i++){
                if(i == 0 ){
                    queue.add(new Node(nowPos+1,nowTotal+numbers[nowPos+1]));
                }else{
                     queue.add(new Node(nowPos+1,nowTotal-numbers[nowPos+1]));
                }
            }
        }
        
        return answer;
    }
}