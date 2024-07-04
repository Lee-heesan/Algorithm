import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String A = st.nextToken();
		int ant = Integer.parseInt(st.nextToken());
		int decimal =0;
		int digit =A.length()-1;
		
		
		
		for(int i=0; i<A.length();i++) {
			int num =0;
			char n = A.charAt(i);
			if('A'<=n && n<='Z') {
				num=A.charAt(i)-'A'+10;
			}else {
				num=Character.getNumericValue(A.charAt(i));
			}
			decimal += num*(int)Math.pow(ant,digit);
			digit--;
		}
		
		System.out.println(decimal);
		

	}

}
