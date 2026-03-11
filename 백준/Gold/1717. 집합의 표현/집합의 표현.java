import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int [n+1];
		
		for(int i = 1; i<=n; i++) {
			arr[i] = i;
		}
		
		
		int a = -1;
		int b = -1;
		int c = -1;
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			c = Integer.parseInt(st.nextToken());
			
			if(c==1) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(find(a)==find(b)) {
					sb.append("YES"+"\n");
				}else {
					sb.append("NO"+"\n");
				}
				
			}else if (c==0) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
		}
		
		System.out.println(sb.toString());
	}
	
	
	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		arr[B] = A;
	}
	
	public static int find(int num) {
		if(arr[num]==num) {
			return num;
		}
		
		return arr[num] = find(arr[num]);
	}
}
