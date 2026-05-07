import java.util.*;

class Solution {

    static class Node implements Comparable<Node>{

        int end;
        int dis;

        public Node(int end, int dis){
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node n1){
            return this.dis - n1.dis;
        }
    }

    public int solution(int n, int[][] costs) {

        int answer = 0;

        boolean[] visited = new boolean[n];

        List<Node>[] list = new ArrayList[n];

        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < costs.length; i++){

            int s = costs[i][0];
            int e = costs[i][1];
            int d = costs[i][2];

            list[s].add(new Node(e,d));
            list[e].add(new Node(s,d));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0,0));

        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(visited[now.end]) continue;

            visited[now.end] = true;

            answer += now.dis;

            for(Node next : list[now.end]){

                if(!visited[next.end]){
                    pq.add(next);
                }
            }
        }

        return answer;
    }
}