import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		static int N ; 
		static int [] arr;
		static boolean [] visited;
		static int [] asr;
		static int max = Integer.MIN_VALUE;
		
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		asr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		
		System.out.println(max);
	}
	
	public static void dfs (int cnt) {
		if(cnt==N) {
			int sum = 0;
			for(int i =1; i<asr.length;i++) {
				sum += Math.abs(asr[i]-asr[i-1]);
			}
			max= Math.max(sum, max);
			return;
		}
		
		
		for(int i = 0; i<N ; i++) {
			if(!visited[i]) {
				visited[i]=true;
				asr[cnt]=arr[i];
				dfs(cnt+1);
				visited[i]=false;
			}
		}
	}

}
