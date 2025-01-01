import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,sCity,eCity;
	static long distance[],cityMoney[];
	static Edge edge[];
	static class Edge{
		int start, end, price;
		public Edge(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		sCity = Integer.parseInt(st.nextToken());
		eCity = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edge = new Edge[M];
		distance = new long[N];
		cityMoney = new long[N];
		Arrays.fill(distance, Long.MIN_VALUE);
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			edge[i]= new Edge(start, end, price);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cityMoney[i] = Long.parseLong(st.nextToken());
		}
		
		distance[sCity] = cityMoney[sCity];
		
		
		//벨만 포드 알고리즘 수행
		// 양수 사이클이 전파되도록 충분히 큰 수로 반복하기
		for(int i =0; i<=N+100; i++) {
			for(int j =0; j<M; j++) {
				int start = edge[j].start;
				int end   = edge[j].end;
				int price = edge[j].price;
				
				
				if(distance[start] == Long.MIN_VALUE) {
					continue;
				}else if(distance[start]==Long.MAX_VALUE) {
					distance[end]= Long.MAX_VALUE;
				}else if(distance[end]<distance[start]+cityMoney[end]-price) {
					distance[end]= distance[start]+cityMoney[end]-price;
					
					//N-1 반복 이후 업데이트 되는 종료 노드는 양수 사이클 연결 노드로 변경
					if(i>=N-1) {
						distance[end]=Long.MAX_VALUE;
					}
				}
			}
		}
		if(distance[eCity] == Long.MIN_VALUE) {
			System.out.println("gg");
		}else if(distance[eCity] == Long.MAX_VALUE) {
			System.out.println("Gee");
		}else {
			System.out.println(distance[eCity]);
		}
		
	}
}
