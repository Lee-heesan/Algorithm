import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A [] = new int[9];
		for(int i =0; i<9;i++) {
			A[i]=Integer.parseInt(br.readLine());
		}
		

		int max=A[0];
		int maxIocation=1;
	    for(int k =0;k<9;k++) {
			if(A[k]>max) {
				max=A[k];
				maxIocation=k+1;
			}
		}
	    
	    bw.write(max+"\n");
	    bw.write(maxIocation+"\n");
	    
	    br.close();
	    bw.flush();
	    bw.close();
	}

}
