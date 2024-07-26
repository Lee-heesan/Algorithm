import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =1; i<=N;i++) {
			int count=0;
			int st=i;
			while(true) {
				if(st/10>0) {
					if((st%10)%3==0&&st%10!=0) {
						sb.append("-");
						count++;
					}
					st/=10;
				}else {
					if(st%3==0) {
						sb.append("-");
						count++;
					}
					break;
				}
			}
			if(count==0) {
				sb.append(i);
			}
			sb.append(" ");
		}
		System.out.println(sb);
		
	}

}
