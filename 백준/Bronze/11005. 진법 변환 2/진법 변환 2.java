
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		ArrayList<Character> charList = new ArrayList<>();
		
		
		while(N >0) {			
			if(N%B<10) {

				charList.add((char)(N % B+'0'));
			}else {

				charList.add((char)(N % B-10+'A'));
			}
			N/=B;
		}		
		
		for(int j=charList.size()-1;j>=0;j--) {
			System.out.print(charList.get(j));
		}
	}

}
