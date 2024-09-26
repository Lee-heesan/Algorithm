
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		st  = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int count = 0;
		
		
		for(int i = 0 ; i<(N-1) ; i++) {
			for(int j= i+1; j<N; j++) {
				if(arr[i]+arr[j]==M) {
					count++;
				}else if(arr[i]+arr[j]>M) {
					break;
				}
			}
		}
		
		
		System.out.println(count);
	}

}
