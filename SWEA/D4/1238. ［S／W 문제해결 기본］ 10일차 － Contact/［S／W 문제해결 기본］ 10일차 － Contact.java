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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int len;
	static int startIdx;
	static int result;
	static List<Integer> [] list;
	static boolean [] visited;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=10; i++) {
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			startIdx = Integer.parseInt(st.nextToken());
			 
			list = new ArrayList[101]; 
			for(int k=1; k<=100; k++) {
				list[k] = new ArrayList<>();
			}
			
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<len/2; j++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				list[start].add(end);
			}
			result = Integer.MIN_VALUE;
			visited = new boolean[101];
			bfs(startIdx);
			
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
	private static void bfs(int sIdx) {
	    Queue<Integer> queue = new LinkedList<>();
	    visited = new boolean[101];
	    queue.add(sIdx);
	    visited[sIdx] = true;

	    int maxNumAtLastLevel = sIdx;

	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        int maxAtThisLevel = Integer.MIN_VALUE;

	        for (int i = 0; i < size; i++) {
	            int now = queue.poll();
	            maxAtThisLevel = Math.max(maxAtThisLevel, now);

	            for (int nxt : list[now]) {
	                if (!visited[nxt]) {
	                    visited[nxt] = true;
	                    queue.add(nxt);
	                }
	            }
	        }

	        // 매 레벨마다 갱신
	        if (!queue.isEmpty()) {
	            maxNumAtLastLevel = maxAtThisLevel;
	        } else {
	            result = maxAtThisLevel;
	        }
	    }
	}
}