
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static int [] parent;
	static int [][] map;
	static int N,M,sNum;
	static boolean [][] visited;
	static ArrayList<ArrayList<int[]>> sumList;
	static ArrayList<int[]> mlist; // 섬 정보
	static PriorityQueue<bEdge> queue;	//다리 정보를 저장할 우선순위 큐
	static class bEdge implements Comparable<bEdge>{
		
		int s, e, v;
		
		bEdge(int s, int e, int v){
			this.s= s;
			this.e = e;
			this.v = v;
		}

		@Override
		public int compareTo(bEdge o) {
			return this.v-o.v;
		}
		
		
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i =0; i<N; i++) {
			st=  new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sNum =1;
		sumList = new ArrayList<ArrayList<int[]>>();
		for(int i =0; i<N; i++) {         // 섬 분리하기
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0 && visited[i][j] != true) {
					BFS(i,j);
					sNum++;
					sumList.add(mlist);
				}
			}
		}
		
		queue = new PriorityQueue<>();
		for(int i=0; i< sumList.size(); i++) { // 섬의 각 지점에서 만들 수 있는 모든 에지를 저장하기
			ArrayList<int[]> now = sumList.get(i);
			for(int j=0; j<now.size(); j++) {
				int r = now.get(j)[0];
				int c = now.get(j)[1];
				int now_S = map[r][c];
				for(int d= 0; d<4; d++) {
					int tempR = dr[d];
					int tempC = dc[d];
					int blenght =0;
					while(r+tempR >=0 && r+tempR <N && c+tempC >= 0 && c+tempC <M) {
						if(map[r+tempR][c+tempC]==now_S) {//같은 섬이면 에지를 만들 수 없음
							break;
						}else if(map[r+tempR][c+tempC]!=0) { // 같은 섬도 아니고 바다도 아니면
							if(blenght > 1) { // 다른 섬 -> 길이가 1이상일 때 에지로 더하기
								queue.add(new bEdge(now_S,map[r+tempR][c+tempC],blenght));
							}
							break;
						}else {
							blenght++;
						}
						
						if(tempR<0) {
							tempR--;
						}else if(tempR>0) {
							tempR++;
						}else if(tempC <0) {
							tempC--;
						}else if(tempC >0) {
							tempC++;
						}
					}
				}
			}
		}
		
		//유니온 파인드
		parent = new int[sNum];
		for(int i=0; i<parent.length; i++) {
			parent[i]=i;
		}
		int useEdge= 0;
		int result =0;
		while(!queue.isEmpty()) {
			bEdge now =queue.poll();
			if(find(now.s) != find(now.e)) {
				union(now.s, now.e);
				result += now.v;
				useEdge++;
			}
		}
		
		if(useEdge == sNum -2) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
	}
	
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		mlist = new ArrayList<int[]>();
		int[] start  = { i, j }; 
		
		queue.add(start);
		mlist.add(start);
		visited[i][j]=true;
		map[i][j]=sNum; // 섬 번호
		
		while(!queue.isEmpty()) {
			int [] now = queue.poll();
			int r = now[0];
			int c = now[1];
			
			for(int d=0; d<4; d++) {  // 탐색
				int tempR = dr[d];
				int tempC = dc[d];
				
				while(r + tempR >= 0 && r + tempR< N && c + tempC >=0 && c + tempC < M) {
					//현재 방문한 적이 없고 바다가 아니면 같은 섬으로 취급하기
					if(visited[r+tempR][c+tempC] == false && map[r+tempR][c+tempC] !=0) {
						addNode(r+tempR, c+tempC, queue);
					}else {
						break;
					}
					
					if(tempR<0) {
						tempR--;
					}else if(tempR>0) {
						tempR++;
					}else if(tempC <0) {
						tempC--;
					}else if(tempC >0) {
						tempC++;
					}
				}
			}
		}
	}
	
	//특정 위치를 섬의 정보로 넣어주는 함수
	private static void addNode(int i, int j, Queue<int[] >queue) {
		map[i][j] = sNum;
		visited[i][j] = true;
		int[] temp = {i,j};
		mlist.add(temp);
		queue.add(temp);
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA!=rootB) {
			parent[rootB] =rootA;
		}
	}
	
	public static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		
		return parent[n]= find(parent[n]);
	}

}
