
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i =0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if(num1>num2) {
				sb.append(lcm(num2,num1)+"\n");
			}else {
				sb.append(lcm(num1,num2)+"\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	public static int lcm(int a, int b) {
		return (a*b)/gcd(a,b);
	}
	
	public static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}
		
		return gcd(b,a%b);
	}

}
