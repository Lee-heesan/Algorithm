import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		int [][] arr = new int [100][100];
	
		for(int i=0; i<10; i++) {
			int length = Integer.parseInt(br.readLine());
			int count=0;	
			
			for(int j=0; j<length;j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k=0; k<length;k++) {
					arr[j][k]= Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j=0; j<length; j++) {
				int last = 0;
				for(int k=0; k<length;k++) {
					 if(arr[k][j]==1) {
							last=1;
					}else if(arr[k][j]==2) {
						if(last==1) {
							count++;
						}
						last=2;
					}
					
				}
			}
			
			sb.append("#").append(i+1).append(" "+count+"\n");
		}
		System.out.println(sb.toString());
	}

}
