
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			sb.append(Binary(Integer.parseInt(st.nextToken()), 0, N-1)+ "\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static int Binary(int findnum ,int start, int end) {
		while(start<end) {
			int mid = (start+end)/2;
			
			if(arr[mid]<findnum){
				start = mid+1;
			}else {
				end = mid;
			}
		}
		
		if(findnum==arr[end]) {
			return 1;
		}
		
		
		return 0;
	}

}
