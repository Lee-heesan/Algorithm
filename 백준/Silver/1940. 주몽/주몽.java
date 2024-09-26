
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		st  = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int count = 0;
		int startIdx = 0;
		int endIdx = N-1;
		
		while(startIdx<endIdx) {
			int sum = arr[startIdx]+arr[endIdx];
			if(sum==M) {
				count++;
				endIdx--;
			}else if(sum>M) {
				endIdx--;
			}else if(sum<M) {
				startIdx++;
			}
		}
		
		System.out.println(count);
	}

}
