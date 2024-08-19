import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution
{
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int [][] arr = new int [100][100];
		
		for(int i = 0; i < 10; i++) {
			int max = Integer.MIN_VALUE;
			int N = Integer.parseInt(br.readLine());
			for(int j =0; j<100; j++) {
				st = new StringTokenizer(br.readLine()," ");
				int widthSum = 0;
				
				for(int k=0; k<100; k++) {
					arr[j][k]= Integer.parseInt(st.nextToken());
					widthSum+=arr[j][k];
				}
				max= Math.max(max, widthSum);
			}
			max = Math.max(max, Math.max(diagonalSum(arr), lengthSum(arr)));
			sb.append("#"+N+" "+max+"\n");
		}
		System.out.println(sb);
	}
	
	public static int diagonalSum(int [][] arr ) {
		int rightSum = 0;
		int leftSum =0;

		for(int i = 0, j = 99; i<100; i++,j--) {
			rightSum+=arr[i][i];
			leftSum+=arr[i][j];
		}
		return Math.max(rightSum, leftSum);
	}
	
	public static int lengthSum(int [][] arr) {
		int lengthMax = Integer.MIN_VALUE;
		for(int i=0; i<100;i++) {
			int sum = 0;
			for(int j=0; j<100; j++) {
				sum+=arr[j][i];
			}
			lengthMax= Math.max(lengthMax, sum);
		}
		return lengthMax;
	}

}
