/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{static int N;
	static int [][] room;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static boolean [][] visited; 
	static List<Integer> [] list;
	static int maxNum;
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i= 1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList[(N*N)+1];
			for(int j=1; j<=N*N; j++) {
				list[j] = new ArrayList<>();
			}
			
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					room[j][k] = Integer.parseInt(st.nextToken());
					list[room[j][k]].add(j); // list[순서].get(0) Y값
					list[room[j][k]].add(k); // list[순서].get(1) X값
				}
			}
			
			max = 0;
			maxNum = 0;
			for(int j=1; j<=N*N; j++) {
				if(!visited[list[j].get(0)][list[j].get(1)]) {
					search(j,j,1);
				}
			}
			
			sb.append("#").append(i).append(" ").append(maxNum).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void search(int start ,int now, int cnt) {
		int y = list[now].get(0);
		int x = list[now].get(1);		
		visited[y][x] = true;
		
		if(max<cnt) { //클 경우
			max = cnt;
			maxNum = start;
		} else if(max == cnt) { // 같은 경우
			maxNum = maxNum>start ? start : maxNum;
		}
		
		
		for(int i =0; i<4; i++) {
			 int newY = y+dy[i];
			 int newX = x+dx[i];
			 
			 if(newY>=0 && newY<N && newX>=0 && newX<N && room[newY][newX]== room[y][x]+1&&!visited[newY][newX]) {
				 search(start, room[newY][newX],cnt+1);
			 }
		}
	}

}
