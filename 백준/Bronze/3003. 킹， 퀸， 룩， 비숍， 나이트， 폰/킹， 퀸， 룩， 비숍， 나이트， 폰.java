import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A[] = new int[6];
		for(int i =0; i<A.length; i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int j=0; j<A.length;j++) {
			switch(j) {
			case 0:case 1:
				if(A[j]<1||A[j]>1) {
						A[j]=1-A[j];
				}else {
					A[j]=0;
				}
				break;
			case 2:case 3:case 4:
				if(A[j]<2||A[j]>2) {
					A[j]=2-A[j];
				}else {
					A[j]=0;
				}
				break;
			case 5:
				if(A[j]<8||A[j]>8) {
					A[j]=8-A[j];
				}else {
					A[j]=0;
				}
				break;
			}
		}
		
		
		for(int k:A) {
			System.out.print(k+" ");
		}
		
	}

}
