import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int arr [];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		arr = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(count.containsKey(arr[i])) {
				count.put(arr[i], count.get(arr[i])+1);
			}else {
				count.put(arr[i], 1);
			}
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0 ; i<M ; i++) {
			int numM= Integer.parseInt(st.nextToken());
			boolean find = countN(numM);
			if(find) {
				sb.append(count.get(numM)+" ");
			}else {
				sb.append(0+" ");
			}
		}
		System.out.println(sb);
	}
	
	public static boolean countN (int M) {
		int min = 0;
		int max = arr.length-1;
		while(min<=max) {
			int mid = (min+max)/2;
			
			if(arr[mid]>M) {
				max=mid-1;
			}else if(arr[mid]<M) {
				min=mid+1;
			}else {
				return true;
			}
		}
		
		
		return false;
	}

}
