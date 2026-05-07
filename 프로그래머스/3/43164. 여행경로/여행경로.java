import java.util.*;

class Solution {

    static boolean[] visited;
    static String[] answer;
    static boolean finished = false;

    static class Node implements Comparable<Node> {

        String str;
        int idx;

        public Node(String str, int idx){
            this.str = str;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node n1){
            return this.str.compareTo(n1.str);
        }
    }

    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];

        answer[0] = "ICN";

        DFS("ICN", tickets, 1);

        return answer;
    }

    public static void DFS(String start, String[][] tickets, int ansIdx){

        // 모든 티켓 사용 완료
        if(ansIdx == tickets.length + 1){
            finished = true;
            return;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                pq.add(new Node(tickets[i][1], i));
            }
        }

        while(!pq.isEmpty()){

            Node nxt = pq.poll();

            visited[nxt.idx] = true;
            answer[ansIdx] = nxt.str;

            DFS(nxt.str, tickets, ansIdx + 1);

            // 정답 찾았으면 즉시 종료
            if(finished) {
                return;
            }
            
            // 실패했으면 복구
            visited[nxt.idx] = false;
        }
    }
}