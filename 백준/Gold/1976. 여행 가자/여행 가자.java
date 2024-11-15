
import java.io.*;
import java.util.*;

public class Main {
	static int [] arr;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i]=i;
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					if(find(i)!=find(j)) {
						union(i,j);
					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int [] plan = new int[M];
		for(int i=0; i<M; i++) {
			plan[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i =0; i<M-1; i++) {
			if(find(plan[i])!=find(plan[i+1])) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
		
	}
	
	public static void union(int A, int B) {
		int rootA = find(A);
		int rootB = find(B);
		
		
		if(rootA == rootB) {
			return;
		}else {
			arr[rootA]=rootB;
		}
	}
	
	public static int find(int num) {
		if(arr[num]==num) {
			return num;
		}
		
		return arr[num] = find(arr[num]);
	}
}