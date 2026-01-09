import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = arr[0];
		int start = 0;
		int end = 0;
		int len = 1;
		int result = Integer.MAX_VALUE;
		
		//투포인터
		while(start<N) {
			if(sum>=S) {
				result = result>len?len:result;
				sum -= arr[start++];
				len--;
			}else if(sum<S) {
				if(end+1>=N) {
					break;
				}
				sum += arr[++end];
				len++;
			}
		}
		
		System.out.println(result==Integer.MAX_VALUE?0:result);
	}

}
