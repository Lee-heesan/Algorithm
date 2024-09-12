import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 

class Solution
{
	static int [] probability = new int [3];
	static String [] arr = new String[3];
	static int now = -1;
	static int k = -1;
	static int max = Integer.MIN_VALUE;
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		arr= new String[3];
	    probability = new int [3];
		
		for(int i =1; i<=T; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			String S = st.nextToken();
			arr = S.split("");
		    now = S.indexOf("o");
		    k = Integer.parseInt(st.nextToken());
			Arrays.fill(probability, 0);
			
			if(k==0) {
				
			}else if (now==0||now==2){
				if(k%2==0) {
					now = 0;
				}else {
					now = 1;
				}
			}else if(now==1) {
				if(k%2==0) {
					now=1;	
				}else {
					now=0;
				}
			}
			sb.append("#").append(i).append(" ").append(now).append("\n");
		}
		System.out.println(sb.toString());
	}
	

}
