import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] A = new int [N];
		int [] B = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		if(Arrays.equals(A, B)) {
			System.out.println(1);
			return;
		}
		
		int [] sorted = Arrays.copyOf(A, N);
		Arrays.sort(sorted);
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < N; i++) {
			map.put(A[i], i);
		}
		
		for(int i = N-1; i>=0; i--) {
			int val = sorted[i];
			int idx = map.get(val);
			
			if(idx != i) {
				 int tmp = A[i];
	             A[i] = val;
	             A[idx] = tmp;
	             
	             map.put(A[i], i);
	             map.put(A[idx], idx);
	             
	             if(Arrays.equals(A, B)) {
	            	System.out.println(1);
	     			return;
	             }
			}
		}
		System.out.println(0);
	}
}
