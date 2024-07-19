
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int C = Integer.parseInt(br.readLine());
		int n0 = Integer.parseInt(br.readLine());

		
		if(A*n0+B<=C*n0&&A<=C) {
			System.out.println('1');
		}else {
			System.out.println('0');
		}
	}

}
