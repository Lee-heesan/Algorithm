import java.io.*;
import java.util.*;

public class Main {
    static int A, B;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            sb.append(bfs(A, B)).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    private static String bfs(int start, int target) {
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[10000];
        
        queue.offer(new Node(start, ""));
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            int num = current.num;
            String path = current.path;
            
            if (num == target) {
                return path;
            }
            
            // 각 연산 수행
            int[] nextNums = {D(num), S(num), L(num), R(num)};
            char[] commands = {'D', 'S', 'L', 'R'};
            
            for (int i = 0; i < 4; i++) {
                int next = nextNums[i];
                
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, path + commands[i]));
                }
            }
        }
        
        return "";
    }
    
    private static int D(int num) {
        return (num * 2) % 10000;
    }
    
    private static int S(int num) {
        return (num == 0) ? 9999 : num - 1;
    }
    
    private static int L(int num) {
        return (num % 1000) * 10 + num / 1000;
    }
    
    private static int R(int num) {
        return (num % 10) * 1000 + num / 10;
    }
    
    static class Node {
        int num;
        String path;
        
        Node(int num, String path) {
            this.num = num;
            this.path = path;
        }
    }
}
