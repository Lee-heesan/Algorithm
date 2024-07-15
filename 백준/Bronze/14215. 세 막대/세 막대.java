import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int [] A = new int[3];
		
		for(int i =0; i<3;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		if(A[0]+A[1]>A[2]) {
			System.out.println(A[0]+A[1]+A[2]);
		}else {
			int plus=A[2]-(A[0]+A[1])+1;
			System.out.println(A[0]+A[1]+A[2]-plus);
		}
		

		
	}

}
