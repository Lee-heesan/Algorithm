import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T; i++) {
			
			st= new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int [] arr=  new int[N];
			int [] S = new int[N];
			List<Integer> list = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);

			S[0]=0;
			for(int j =1; j<N; j++) {
				S[j]=arr[j]-arr[j-1];
			}
			
			
			boolean isEnd = true;
			int start =1;
			while(isEnd) {
				int sum = 0;
				for(int k=start; k<K+start-1; k++) {
					sum += S[k];
					if(k==N-1) {
						isEnd=false;
					}
				}
				start++;
				list.add(sum);
			}
			
			sb.append("#").append(i+" ").append(Collections.min(list)).append("\n");	
		}
		System.out.println(sb);

	}

}
