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
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int [][] arr;
	static int n,m;
	public static void main(String args[])  throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine());
		 for(int i=1; i<=T; i++) {
			 st = new StringTokenizer(br.readLine());
			 n = Integer.parseInt(st.nextToken());
			 m = Integer.parseInt(st.nextToken());
			 
			 arr = new int [n*3][n*3];
			 for(int j =n; j<2*n; j++) {
				 st = new StringTokenizer(br.readLine());
				 for(int k=n; k<2*n; k++) {
					 arr[j][k]= Integer.parseInt(st.nextToken());
				 }
			 }
			 
			 int max = Integer.MIN_VALUE;
			 for(int j=n; j<2*n; j++) {
				 for(int k=n; k<2*n; k++) {					 
					 //+메소드  plusCal(j,k);
					 //x메소드  xCal(j,k);
					 max = Math.max(max, Math.max(plusCal(j,k), xCal(j,k)));
				 }
			 }
			 sb.append("#").append(i).append(" ").append(max).append("\n");
		 }
		 System.out.println(sb.toString());
	}
	
	
	public static int plusCal(int y, int x) {
		int sum =0;
		for(int i = -m+1; i<m ; i++) {
		   sum += arr[y+i][x];
		   sum += arr[y][x+i];
		}
		
		return sum - arr[y][x];
	}
	public static int xCal(int y, int x) {
		int sum = 0;
		for (int k = -m + 1; k <= m - 1; k++) {
            sum += arr[y + k][x + k];
            sum += arr[y - k][x + k];
        }
		return sum - arr[y][x];
	}
}