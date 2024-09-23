import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		static int [] arr;
		static int N;
		static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		int max = 0;
		int min = 0;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(max < arr[i]) {
				max= arr[i];
			}
		}
		// 이분 탐색 (upper bound)
		while(min < max) {
					
			int mid = (min + max) / 2;
			long sum = 0;
			for(int treeHeight : arr) {
						
			
				if(treeHeight - mid > 0) { 
					sum += (treeHeight - mid);
					}
			}
					
		 
			if(sum < M) {
				max = mid;
			}
					
				
			else {
				min = mid + 1;
			}
		}
				
		System.out.println(min - 1);
				
	}
}