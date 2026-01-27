import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, H;
	static int result = 0;
	static Map<Integer, Integer> resultMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int [] down = new int [H+2];
		int [] up   = new int [H+2];
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(i%2==0) {
				up[x]++;
			}else {
				down[x]++;
			}
		}
		
		for(int i = H-1; i>=1; i--) {
			down[i] += down[i + 1];
			up[i] += up[i + 1];
		}
		
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		
		for(int i =1; i<=H; i++) {
			int downCnt = down[i];
			int upCnt = up[H-i+1];
			int total = downCnt+upCnt;
			
			if(total<min) {
				min = total;
				cnt=1;
			}else if (total==min) {
				cnt++;
			}
		}
		
		System.out.println(min+" "+cnt);
	}
}
