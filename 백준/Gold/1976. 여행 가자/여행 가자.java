
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	// 1976 유니온 파인드
	static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		
		arr = new int[N+1];
		for(int i=1; i<=N;i++) {
			arr[i]= i;
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					if(find(i)==find(j)) {
						continue;
					}else {
						union(i,j);
					}
				}
			}
		}
		
		int [] plan = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<M;i++) {
			plan[i]=Integer.parseInt(st.nextToken());	
		}
		
		
		for(int i=0; i<M-1;i++) {
			int num1 = plan[i];
			int num2 = plan[i+1];
			
			if(find(num1)!=find(num2)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
		
	}
	
	public static void union(int num1, int num2) {
		int rootX = find(num1);
		int rootY = find(num2);
		
		if(rootX!=rootY) {
			arr[rootX]=rootY;
		}
	}
	
	
	
	public static int find(int num) {
		if(arr[num]==num) {
			return num;
		}
		return arr[num]= find(arr[num]);
	}
}
