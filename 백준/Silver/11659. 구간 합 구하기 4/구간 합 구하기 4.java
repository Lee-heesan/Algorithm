import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	static int [] C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M =  Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		arr = new int[M+1];
		C   = new int[M+1];

		st =new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			C[i] = C[i-1]+arr[i];
		}
		
		
		for(int i =0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(start==end) {
				sb.append(arr[start]).append("\n");
				continue;
			}
			
			int sum = 0;
			sum = C[end]-C[start-1]; 	
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
