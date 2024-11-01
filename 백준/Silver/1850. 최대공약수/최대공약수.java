
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Long num1 = Long.parseLong(st.nextToken());
		Long num2 = Long.parseLong(st.nextToken());
		
		Long tmp =0L;
		
		if(num1>num2) {
			tmp = gcd(num2,num1);
		}else {
			tmp =gcd(num1,num2);
		}
		
		for(int i =0; i<tmp; i++) {
			sb.append(1);
		}
		
		System.out.println(sb);
	}
	
	
	public static Long gcd(long a, long b) {
		while(b!=0) {
			Long temp = b;
			b= a%b;
			a = temp;		
		}
		
		return a;
	}

}
