import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		
		int A;
		String B;
		StringTokenizer st ;
		
		for (int i=0; i<num;i++) {
			st = new StringTokenizer(br.readLine()," ");
			A=Integer.parseInt(st.nextToken());
			B=st.nextToken();
			
			String[] C = B.split("");
			for(int j = 0; j<C.length;j++) {
				for(int k =0;k<A;k++) {
					System.out.print(C[j]);
				}
			}
			System.out.print("\n");
		}
		br.close();
	}

}
