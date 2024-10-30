
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean [] prime;	
	static int end,start;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		prime = new boolean[end+1];
		
		decimal();
		
		for(int i = start; i<=end; i++) {
			if(!prime[i]) sb.append(i+"\n");
		}
		
		System.out.println(sb.toString());

	}
	
	
	public static void decimal() {
		
		prime[0] = prime[1] = true;
		
		for(int i =2; i<=Math.sqrt(prime.length); i++) {
			if(prime[i]) {
				continue;
			}
			
			for(int j = i*i; j<prime.length; j+=i) {
					prime[j]=true;
			}
		}
	}

}
