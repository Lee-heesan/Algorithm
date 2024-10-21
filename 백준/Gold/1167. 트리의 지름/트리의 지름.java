import java.io.*;
import java.util.*;

public class Main {
    static List<int[]>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine()); 
        list = new List[V + 1];
        visited = new boolean[V + 1];

        
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

       
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            while (true) {
                int vertex = Integer.parseInt(st.nextToken());
                if (vertex == -1) {
                	break; 
                }
                int distance = Integer.parseInt(st.nextToken());

           
                list[num].add(new int[] { vertex, distance });
                list[vertex].add(new int[] { num, distance });
            }
        }

      
        int[] firstBFS = BFS(1); 
        
        
        visited = new boolean[V + 1]; 
        int[] secondBFS = BFS(firstBFS[0]);

       
        System.out.println(secondBFS[1]);
    }

    
    public static int[] BFS(int start) {
        Queue<int[]> q = new LinkedList<>();
        visited[start] = true;
        q.add(new int[] { start, 0 }); 

        int maxNode = start;
        int maxDistance = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currNode = current[0];
            int currDistance = current[1];

            // 최대 거리 갱신
            if (currDistance > maxDistance) {
                maxDistance = currDistance;
                maxNode = currNode;
            }

            // 인접 노드 탐색
            for (int[] neighbor : list[currNode]) {
                int nextNode = neighbor[0];
                int nextDistance = neighbor[1];

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(new int[] { nextNode, currDistance + nextDistance });
                }
            }
        }

        // {가장 먼 노드, 최대 거리} 반환
        return new int[] { maxNode, maxDistance };
    }
}
