import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		
		int len = Integer.parseInt(br.readLine());
		int sum= 0;
		String num[] = br.readLine().split("");
		
		for(int i =0; i<len;i++) {
			sum+=Integer.parseInt(num[i]);
		}
		System.out.print(sum);
	}

}
