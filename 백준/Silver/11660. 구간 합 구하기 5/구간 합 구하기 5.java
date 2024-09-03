
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int [] start= new int[2];
	static int [] end= new int[2];
	static int sum;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		// N*N 크기
		int N = Integer.parseInt(st.nextToken());
		//합을 구해야하는 횟수
		int M = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[N+1][N+1];
		
		for(int i = 1; i<=N ; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				arr[i][j]=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i =0 ; i<M;i++) {
			sum = 0 ;
			
			st= new StringTokenizer(br.readLine());
			
			start[0]= Integer.parseInt(st.nextToken());
			start[1]= Integer.parseInt(st.nextToken());
			end[0]  = Integer.parseInt(st.nextToken());
			end[1]  = Integer.parseInt(st.nextToken());
			
			sum = arr[end[0]][end[1]]-arr[start[0]-1][end[1]]-arr[end[0]][start[1]-1]+arr[start[0]-1][start[1]-1];
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}