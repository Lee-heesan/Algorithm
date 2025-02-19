import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr = new int[10]; 
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int sum = A*B*C;
		String str = String.valueOf(sum);
		
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-'0']++;
		}
		
		for(int i =0; i<=9; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
