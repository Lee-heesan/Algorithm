import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [] redOrBlue;
	static List<Integer> [] list;
	static boolean isBipartite; 
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			redOrBlue = new int[V+1];
			isBipartite = true;
			
			for(int j=1; j<=V; j++) {
				list[j] = new ArrayList<Integer>();
			}
			
			for(int j=0 ; j<E; j++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				list[A].add(B);
				list[B].add(A);
			}
			
			for(int j=1; j<=V; j++) {
				 if (redOrBlue[j] == 0) { // 방문하지 않은 경우
	                    if (!bfs(j)) {
	                        isBipartite = false;
	                        break;
	                    }
	                }
			}
			
			if(isBipartite) {
				sb.append("YES"+"\n");	
			}else {
				sb.append("NO"+"\n");
			}
			
		}
		
		System.out.println(sb.toString());

	}
	
	public static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        redOrBlue[start] = 1; 

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : list[current]) {
                if (redOrBlue[neighbor] == 0) { 
                    redOrBlue[neighbor] = 3 - redOrBlue[current]; 
                    queue.add(neighbor);
                } else if (redOrBlue[neighbor] == redOrBlue[current]) {
                    return false; 
                }
            }
        }

        return true;
    }

}
