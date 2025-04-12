import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static int n,m;
	static int [][] D;
	static int [][] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		D = new int[n+1][n+1];
		dist = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = 1000001;
				if (i != j)
					D[i][j] = 1000001;
			}
		}
		
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			D[a][b] = Math.min(D[a][b], c);
			dist[a][b] = a;
		}
		
		//플로이드 워셜
		for(int k =1; k<=n; k++) {
			for(int s = 1; s<=n; s++) {
				for(int e = 1; e<=n; e++) {
					if(D[s][e] > D[s][k]+D[k][e]) {
						D[s][e] =D[s][k]+D[k][e];
						dist[s][e] = dist[k][e];
					}
				}
			}
		}
		
		// 도시 i에서 j로 가는데 필요한 최소 비용
		for(int i =1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(D[i][j]==1000001) {
					sb.append("0").append(" ");
				}else {
					sb.append(D[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		Stack<Integer> stack = new Stack<>();
		//
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dist[i][j] == 1000001) {
					sb.append(0 + "\n");
				}else {
					int p = j; 
					stack.push(j);
					while (i != dist[i][p]) {
						p = dist[i][p];
						stack.push(p);
					}
					sb.append((stack.size() + 1) + " "); // 갯수
					sb.append(i + " "); //자기 자신
					while (!stack.empty()) { // 경로
						sb.append(stack.pop() + " ");	
					}
					sb.append("\n");
				}
			}
		}
		
		
		System.out.println(sb.toString());
		
	}

}