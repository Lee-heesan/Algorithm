import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i =1 ; i<=T; i++) {
			String str = br.readLine();
			String [] arr = str.split("");
			
			int countA =0;
			int countB =0;
			for(int j=0; j<arr.length; j++) {
				if(arr[j].equals("o")) {
					countA++;
				}else {
					countB++;
				}
			}
			
			if(arr.length!=15) {
				countA += (15-arr.length);
			}
			
			sb.append("#").append(i).append(" ");
			if(countA>countB) {
				sb.append("YES");
			}else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	
	}
}