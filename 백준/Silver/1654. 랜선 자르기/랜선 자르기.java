
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	static int K,N;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		long right = 0;
		for(int i =0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}
		
		right++;
		long left = 0;
		long mid = 0;
		
		while(left < right) {
			 mid = (left + right)/ 2;
			
			
			if(getCount(mid) < N) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(left-1);
		
	}
	
	 public static long getCount(long mid) {
	        long count = 0;

	        
	        for (int i = 0; i < K; i++) {
	            count += arr[i] / mid;
	        }

	        return count;
	    }

}
