import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int count=0;
		int scount=0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		for(int i=0;i<A;i++) {
			int num = Integer.parseInt(st.nextToken());
			for(int j=1;j<=num;j++) {
				if(num%j==0) {
					scount++;
				}
			}
			if(scount==2) {
				count++;
			}
			scount=0;
		}
		System.out.println(count);
	}

}
