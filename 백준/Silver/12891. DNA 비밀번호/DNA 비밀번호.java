import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int A,C,G,T;
	static int nowA=0,nowC=0,nowG=0,nowT = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		char [] arr = st.nextToken().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		for(int i =0; i<P; i++) {
			add(arr[i]);
		}
		int start = 0;
		int end = P - 1;
		int count = 0;
		count = count + check(nowA,nowC,nowG,nowT);
		
		while (end + 1 < S) {
		    remove(arr[start++]);   
		    add(arr[++end]);        
		    count += check(nowA, nowC, nowG, nowT);
		}
		
		System.out.println(count);
	}
	
	public static int check(int nowA, int nowC, int nowG, int nowT) {
		if(nowA>=A && nowC>=C && nowG>=G && nowT>=T) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void add(char now) {
		if(now=='A') {
			nowA++;
		}else if (now == 'C') {
			nowC++;
		}else if (now == 'G') {
			nowG++;
		}else if (now == 'T') {
			nowT++;
		}
	}
	
	public static void remove(char now) {
		if(now=='A') {
			nowA--;
		}else if (now == 'C') {
			nowC--;
		}else if (now == 'G') {
			nowG--;
		}else if (now == 'T') {
			nowT--;
		}
	}
}
