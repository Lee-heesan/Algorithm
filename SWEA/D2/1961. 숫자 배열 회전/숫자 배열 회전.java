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
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{	static int [][] arr;
	static int [][] result;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i =1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int [N][N];
			result = new int[N][3];
			for(int j = 0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k =0; k<N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int index = 0;
			// 90도
			for(int k = 0; k<N; k++) {
				int sum = 0;
				for(int j =N-1; j>=0; j--) {
					sum = (sum*10) + arr[j][k];
				}	
				result[index++][0] = sum;
			}
			
			index = 0;
			// 180도  
			for(int k = N-1; k>=0; k--) {
				int sum = 0;
				for(int j =N-1; j>=0; j--) {
					sum = (sum*10) + arr[k][j];
				}	
				result[index++][1] = sum;
			}
			
			index = 0;
			//270도
			for(int k = N-1; k>=0; k--) {
				int sum = 0;
				for(int j =0; j<N; j++) {
					sum = (sum*10) + arr[j][k];
				}	
				result[index++][2] = sum;
			}
			

			sb.append("#").append(i).append("\n");
			for(int j =0; j<N; j++) {
				for(int k=0; k<3; k++) {
					String str = Integer.toString(result[j][k]);
					if(str.length()!=N) {
						while(str.length()!=N) {
							str = "0"+str;
						}
					}
					sb.append(str+" ");
				}
				sb.append("\n");
			}
			
		}
		
		System.out.print(sb.toString());

	}

}
