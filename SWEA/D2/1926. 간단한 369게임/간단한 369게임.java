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
		
		for(int i=1; i<=N;i++) {
			String tmp = String.valueOf(i);
			
			if(tmp.contains("3")||tmp.contains("6")||tmp.contains("9")) {
				tmp = tmp.replaceAll("[369]", "-");
				tmp = tmp.replaceAll("[0124578]", "");
				sb.append(tmp);
			}else {
				sb.append(tmp);
			}
			sb.append(" ");
		}
		
		System.out.println(sb);
	}

}
