
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		for(int i =1; i<=N;i++) {
			arr[i]=i;
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					union(i,j);
				}else {
					continue;
				}
			}
		}
		
		st= new StringTokenizer(br.readLine());
		int [] root = new int[M];
		for(int i=0; i<M; i++) {
			root[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<M-1; i++) {
			int a = root[i];
			int b = root[i+1];
			
			if(find(a)!=find(b)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		arr[rootA]=rootB;
	}
	
	public static int find(int X) {
		if(arr[X]==X) {
			return X;
		}
		
		return arr[X]=find(arr[X]);
	}

}
