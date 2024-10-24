import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	static int M,N;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			max = Math.max(arr[i],max);
		}
		
		System.out.println(Binary(max,sum) );
	}
	
	public static long Binary(long left , long right) {
		
		while(left<right) {
			long mid = (left+right)/2;
	//		System.out.println("left : " +left + " right : "+ right + " result mid is : "+ mid);
	//	    System.out.println("GetCount"+" "+ getCount(mid));
			if(getCount(mid) > M) {
				left = mid+1;
			}else {
				right=mid;
			}
		}
		
		
		return left;
	}
	
	   private static long getCount(long mid) {
	        long count = 1;
	        long remain = mid;
	        for (int i = 0; i < N; i++) {
	            if (remain < arr[i]) {
	                remain = mid;
	                count++;
	            }
	            remain -= arr[i];
	        }
	        return count;
	    }
}
