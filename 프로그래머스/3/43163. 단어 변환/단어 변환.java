import java.util.*;

class Solution {
    
    static class Node {
        String word;
        int cnt;
        
        public Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        boolean exists = false;
        for(String w : words){
            if(w.equals(target)){
                exists = true;
                break;
            }
        }
        if(!exists) return 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            if(now.word.equals(target)){
                return now.cnt;
            }
            
            for(int i = 0; i < words.length; i++){
                if(visited[i]) continue;
                
                int diff = 0;
                for(int j = 0; j < now.word.length(); j++){
                    if(now.word.charAt(j) != words[i].charAt(j)){
                        diff++;
                    }
                }
                
                if(diff == 1){
                    visited[i] = true;
                    queue.add(new Node(words[i], now.cnt + 1));
                }
            }
        }
        
        return 0;
    }
}