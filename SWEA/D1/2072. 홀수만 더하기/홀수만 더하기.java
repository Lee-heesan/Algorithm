import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			st= new StringTokenizer(br.readLine()," ");
			
			int A=0;
			int sum=0;
			for(int j=0;j<10;j++) {
				A=Integer.parseInt(st.nextToken());
				if(A%2==0) {
					continue;
				}else if(A%2==1) {
					sum+=A;
				}
			}
			
			sb.append("#").append(i+1).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());

	}

}
