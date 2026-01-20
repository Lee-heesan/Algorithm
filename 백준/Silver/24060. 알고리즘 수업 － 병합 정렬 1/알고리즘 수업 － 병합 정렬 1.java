import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	static int N,K;
	static int result = -1;
	static int [] tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		tmp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(arr, 0, arr.length-1);
		
		System.out.println(result==-1?-1:result);
	}
	
	public static void merge_sort(int [] arr, int start, int end) {
		if(start<end) {
			int q = start + (end - start) / 2; 
			merge_sort(arr, start, q);
			merge_sort(arr, q+1, end);
			merge(arr, start, q, end);
		}
	}
	
	
	public static void merge(int [] arr, int start, int mid, int end) {
		int i = start;
		int j = mid+1;
		int t = start;
		
		while (i<=mid && j<=end) {
			if(arr[i]<=arr[j]) {
				tmp[t++] = arr[i++];
			}else {
				tmp[t++] = arr[j++];
			}
		}
		
		while (i<=mid) {
			tmp[t++] = arr[i++];
		}
		
		while (j<=end) {
			tmp[t++] = arr[j++];
		}

		for(int k = start; k <= end; k++) {
			arr[k] = tmp[k];
			cnt++;
			
			if(cnt == K) {
				result = arr[k];
				return;
			}
		}
	}
}
