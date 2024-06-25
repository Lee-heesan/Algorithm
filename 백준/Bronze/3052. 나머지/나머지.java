
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int [] A = new int [10];
		int find=0;
		for(int i=0;i<10;i++) {
			A[i]=Integer.parseInt(br.readLine())%42;
		}
		
		for(int k=0;k<10;k++) {
			for(int j=k+1;j<10;j++) {
				if(A[k]==A[j]) {
					find++;
					break;
				}else {
					continue;
				}
			}
		}
		int count = 10-find;
		System.out.print(count);
		
	}

}
