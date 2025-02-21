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
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int N;
	static boolean [] visited;
	static int temp; 
	static int k; // 증가 수
	static int count; // visited된 개수
	static boolean isEnd; //끝난 지 확이
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[10];
			
			temp = N;
			k = 2;
			count =0;
			isEnd = false;
			
			while(true){
				while(true) {
					if(!visited[temp%10]) {
						visited[temp%10] = true;	
						count++;
						if(count == 10) {
							isEnd = true;
							break;
						}
					}
					temp /= 10;
					if(temp==0) {
						break;
					}
				}
				
				if(isEnd) {
					sb.append("#").append(i).append(" ").append(N*(k-1)).append("\n");
					break;
				}
				
				temp = N * (k++);
			}
		}
		
		System.out.println(sb.toString());
	}
}