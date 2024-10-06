import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int [] arr;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T; i++) {
			int count = 0;
			arr= new int[3];
			st= new StringTokenizer(br.readLine());
			
			for(int j =0 ; j<3; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			
			if(arr[2]<3) {
				sb.append("#").append(i).append(" ").append(-1).append("\n");
				continue;
			}
			
			for(int j=2; j>0; j--) {
				if(arr[j]<=arr[j-1]) {
					count += arr[j-1]-(arr[j]-1);
					arr[j-1] = (arr[j]-1);
				}
				if(arr[j-1]<=0) {
					count=-1;
					break;
				}
			}
			
			sb.append("#").append(i).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

}
