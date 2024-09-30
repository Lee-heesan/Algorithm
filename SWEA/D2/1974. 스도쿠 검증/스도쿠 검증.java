import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution
{
    static int [][] arr ;
	static boolean [] check;
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T =  Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T ; i++) {
			arr= new int [10][10];
			int [][] C = new int [10][10];
			int answer = 1;
			
			for(int j=1; j<10;j++) {
				st= new StringTokenizer(br.readLine());
				int sum = 0;
				if(answer!=0) {
					for(int k =1; k<10; k++){
						arr[j][k]=Integer.parseInt(st.nextToken());
						C[j][k]=arr[j][k]+C[j-1][k]+C[j][k-1]-C[j-1][k-1];
						sum+=arr[j][k];
					}
				}
				// 가로 검사
				if(sum!=45) {
					answer = 0;
				}
			}
			
			if(answer==0) {
				sb.append("#").append(i).append(" ").append(answer).append("\n");
				continue;
			}
			
			//세로 검사
			for(int j = 1; j<10; j++) {
				int sum = 0;
				if(answer!=0) {
					for(int k=1; k<10; k++) {
						sum+=arr[k][j];
					}
				}
				if(sum!=45) {
					answer=0;
					break;
				}
			}
			if(answer==0) {
				sb.append("#").append(i).append(" ").append(answer).append("\n");
				continue;
			}
			
			for(int j=3; j<10;j=j+3) {
				for(int k=3; k<10; k=k+3) {
					if(C[j][k]-C[j-3][k]-C[j][k-3]+C[j-3][k-3]!=45) {
						answer=0;
						break;
					}
				}
				if(answer==0) {
					break;
				}
			}
			
			sb.append("#").append(i).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}