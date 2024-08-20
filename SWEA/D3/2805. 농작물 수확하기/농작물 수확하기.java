import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		
		for(int i=0 ; i<T; i++) {
			N=Integer.parseInt(br.readLine());
			int start =N/2;
			int end =N/2;
			int sum=0;
			
			for(int j=0; j<N; j++) {
				String str = br.readLine();
				str = str.substring(start,(end+1));
				for(int k = 0; k<str.length();k++) {
					sum+=str.charAt(k)-'0';
				}
				
				
				if(j>=N/2) {
					start++;
					end--;
				}else if(j<N/2) {
					start--;
					end++;
				}
			}
			sb.append("#"+(i+1)+" " +sum+"\n");
		}
		System.out.println(sb);
	}

}