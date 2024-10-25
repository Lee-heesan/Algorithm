
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
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int lo =  1;
		int hi = 0;
		int sum = 0;
		
	
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i]; 
			hi = Math.max(hi, arr[i]);
		}
		
		int total = Integer.parseInt(br.readLine());
		
		if(sum<=total) {
			System.out.println(hi);
			return;
		}

		
		while(lo<hi-1) {
			int mid = (lo+hi)/2;
			int MidSum = 0;
			for(int i =0; i<N; i++) {
				MidSum += Math.min(arr[i],mid);
			}
			
			if(MidSum<=total) {
				lo = mid;
			}else {
				hi = mid;
			}
			
		}

		System.out.println(lo);
		
		
		
	}

}
