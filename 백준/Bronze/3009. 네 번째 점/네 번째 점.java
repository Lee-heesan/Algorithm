
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int [][]A = new int[3][2];
		
		for(int i=0; i<3;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			A[i][0]=Integer.parseInt(st.nextToken());
			A[i][1]=Integer.parseInt(st.nextToken());
		}
		
		
		// x 구하기
		int sum_x =A[0][0];
		
		if(sum_x!=A[1][0]) {
			if(sum_x==A[2][0]) {
				sum_x=A[1][0];
			}
		}else {
			sum_x=A[2][0];
		}
		
		
		//y 구하기 
		int sum_y = A[0][1];
		
		if(sum_y!=A[1][1]) {
			if(sum_y==A[2][1]) {
				sum_y=A[1][1];
			}
		}else {
			sum_y=A[2][1];
		}
		
		System.out.println(sum_x +" "+sum_y);
	}

}
